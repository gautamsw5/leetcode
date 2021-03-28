class Solution
{
    public String longestPalindrome(String S)
    {
        char[] s = S.toCharArray();
        int n = s.length;
        boolean[][] dp = new boolean[n][n];
        int l = 0,
        r = 0;
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
            if(i+1<n && s[i]==s[i+1])
            {
                l=i;
                r=i+1;
                dp[i][i+1]=true;
            }
        }
        for(int k=1;k<n;k++)
        {
            int i = 0, j = k;
            while(i<n && j<n)
            {
                if(s[i]==s[j] && dp[i+1][j-1])
                {
                    dp[i][j] = true;
                    if(j-i+1> r-l+1)
                    {
                        l=i;
                        r=j;
                    }
                }
                //System.out.println(i+" "+j);
                i++;
                j++;
            }
        }
        return S.substring(l,r+1);
    }
}