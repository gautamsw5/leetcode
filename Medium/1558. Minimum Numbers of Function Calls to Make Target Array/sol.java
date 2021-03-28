class Solution {
    public int minOperations(int[] arr)
    {
        boolean f=true;
        int ans = 0;
        while(f)
        {
            f=false;
            for(int i=0; i<arr.length; i++)
            {
                if(arr[i]%2==1)
                {
                    arr[i]--;
                    ans++;
                }
                if(arr[i]>0)
                {
                    f=true;
                }
                arr[i]=arr[i]/2;
            }
            if(f)
                ans++;
        }
        return ans;
    }
}