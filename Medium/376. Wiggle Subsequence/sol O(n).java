class Solution
{
    public int wiggleMaxLength(int[] arr)
    {
        int ret = 0;
        // Positive diff first     + - + - ... 
        int i = 1,
        ans=1;
        while(i<arr.length)
        {
            while(i<arr.length && arr[i]>=arr[i-1])
                i++;
            if(i<arr.length)
            {
                ans++;
                i++;
            }
            while(i<arr.length && arr[i]<=arr[i-1])
                i++;
            if(i<arr.length)
            {
                ans++;
                i++;
            }
        }
        // Negative diff
        i = 1;
        ret=1;
        while(i<arr.length)
        {
            while(i<arr.length && arr[i]<=arr[i-1])
                i++;
            if(i<arr.length)
            {
                ret++;
                i++;
            }
            while(i<arr.length && arr[i]>=arr[i-1])
                i++;
            if(i<arr.length)
            {
                ret++;
                i++;
            }
        }
        return Math.max(ret,ans);
    }
}