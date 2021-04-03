class LIS
{
    public int lengthOfLIS(int[] arr)
    {
        int n = arr.length;
        Integer[] prev = new Integer[n];
        int[] length = new int[n];
        Arrays.fill(length,1);
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(arr[i]>arr[j])
                {
                    if(prev[i]==null)
                    {
                        prev[i]=j;
                        length[i]++;
                    }
                    else if(length[j]>length[prev[i]])
                    {
                        prev[i]=j;
                        length[i]=length[j]+1;
                    }
                }
            }
        }
        int ans=0; for(int i : length) if(i>ans) ans = i;
        return ans;
    }
}