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
    public int maximumScore(int[] nums, int[] multipliers)
    {
        return maximize(nums,multipliers,0,0,nums.length-1,0);
    }
}