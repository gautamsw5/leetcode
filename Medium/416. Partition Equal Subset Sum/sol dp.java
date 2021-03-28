class Solution
{
    public boolean canPartition(int[] arr)
    {
        int sum = 0;
        for(int i:arr)
        {
            sum += i;
        }
        if(sum%2==1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;   // if empty arr
        for(int i : arr)
        {
            for(int s=sum;s>=0;s--) // reverse so that 'set' is not changed but 'next' is changed (elements can be used only once thats why revese)
            {
                if(s+i<=sum && dp[s]) dp[s+i]=true;
            }
            if(i<=sum) dp[i]=true; // add at last otherwise 2*i will also get added if 2*i<=sum
        }
        return dp[sum];
    }
}