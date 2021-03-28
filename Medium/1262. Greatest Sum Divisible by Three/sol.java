class Solution
{
    public int maxSumDivThree(int[] arr)
    {
        int[][] dp = new int[arr.length][3];
        dp[0][arr[0]%3] = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]%3==0)
            {
                for(int x=0; x<3; x++)
                {
                    if(x==0 || dp[i-1][x]!=0)
                    dp[i][x] = dp[i-1][x]+arr[i];
                }
            }
            else
            {
                for(int x=0; x<3; x++)
                {
                    dp[i][x] = Math.max(dp[i][x],dp[i-1][x]);
                    dp[i][(dp[i-1][x]+arr[i])%3] = Math.max( dp[i][(dp[i-1][x]+arr[i])%3],
                                                            dp[i-1][x]+arr[i] );
                }
                for(int x=0; x<3; x++)
                {
                    dp[i][x] = Math.max(dp[i][x],dp[i-1][x]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[arr.length-1][0];
    }
}