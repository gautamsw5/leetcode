class Solution
{
    public int countVowelStrings(int n)
    {
        if(n==1)
        {
            return 5;
        }
        //Map<Integer,Integer> dp = new HashMap<Integer,Integer>();
        int[][] dp = new int[n+1][6];
        dp[1][0]=5;
        dp[2][1]=5;
        dp[2][2]=4;
        dp[2][3]=3;
        dp[2][4]=2;
        dp[2][5]=1;
        for(int i=3;i<n+1;i++)
        {
            for(int j=1;j<6;j++)
            {
                dp[i][j]=dp[i-1][j];
                for(int k=j+1;k<6;k++)
                {
                    //dp[(i,j)]+=dp[(i-1,k)]
                    //dp.put(i*10+j,dp.get(i*10+j)+dp.get((i-1)*10+k));
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }
        //return dp.get(n*10+1)+dp.get(n*10+2)+dp.get(n*10+3)+dp.get(n*10+4)+dp.get(n*10+5);
        return dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4]+dp[n][5];
    }
}