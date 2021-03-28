class Solution
{
    private int maximize(int[] arr, int[] brr, int i, int l, int r, int sum)
    {
        if(l<0 || r>=arr.length || i>=brr.length)
        {
            return sum;
        }
        if(l==r)
        {
            //System.out.println(l);
            return sum + arr[l]*brr[i];
        }
        return Math.max(maximize(arr,brr,i+1,l+1,r,sum + arr[l]*brr[i]),maximize(arr,brr,i+1,l,r-1,sum + arr[r]*brr[i]));
    }
    public int maximumScore(int[] arr, int[] mul)
    {
        //return maximize(arr,mul,0,0,nums.length-1,0);
        int n = mul.length;
        int[][] dp = new int[n+1][n+1];
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = arr[i];
            b[i] = arr[arr.length-i-1];
        }
        //System.out.println(Arrays.toString(b));
        for(int i=1;i<=n;i++)
        {
            dp[i][0] = dp[i-1][0] + mul[i-1]*b[i-1];
            dp[0][i] = dp[0][i-1] + mul[i-1]*a[i-1];
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(i+j-1<mul.length)
        dp[i][j]=Math.max(dp[i][j-1]+mul[i+j-1]*a[j-1],dp[i-1][j]+mul[i+j-1]*b[i-1]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<=n; i++)
        {
            ans = Math.max(ans,dp[i][n-i]);
        }
        //System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}