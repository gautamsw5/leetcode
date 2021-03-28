class Solution
{
    public int minInsertions(String s)
    {
        char[] a = s.toCharArray();
        char[] b = a.clone();
        int i=0,
        j=a.length-1,
        n = a.length;
        while(i<j)
        {
            char t = b[i];
            b[i++] = b[j];
            b[j--] = t;
        }
        int[][] dp = new int[n+1][n+1];
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(a[i-1]==b[j-1])
                {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
                dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return n-dp[n][n];
    }
}