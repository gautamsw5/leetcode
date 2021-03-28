class Solution
{
    public int minSteps(int N)
    {
        int[] dp = new int[N+1];
        dp[1] = 0;
        for(int n=2; n<=N; n++)
        {
            dp[n] = n;
            for(int i=1; i<Math.min(Math.sqrt(n)+2,n); i++)
            {
                if(n%i==0)
                {
                    dp[n] = Math.min(dp[n],Math.min(dp[i]+n/i,dp[n/i]+i));
                }
            }
        }
        return dp[N];
    }
}