class LISop
{
    int bins(int[] arr, int x, int l, int r)
    {
        while(l<=r)
        {
            int mid = (r+l)/2;
            if(arr[mid]>=x && (mid==0 || arr[mid-1]<x))
            {
                return mid;
            }
            else if(arr[mid]<x)
            {
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        return -1;
    }
    public int lengthOfLIS(int[] arr)
    {
        int n = 0;
        int[] res = new int[arr.length];
        res[0]=arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]<res[n])
            {
                res[bins(res,arr[i],0,n)]=arr[i];
            }
            else if(arr[i]>res[n])
            {
                res[++n]=arr[i];
            }
        }
        return n+1;
    }
}