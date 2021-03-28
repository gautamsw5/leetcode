class Solution
{
    public int tupleSameProduct(int[] arr)
    {
        int[] brr = new int[(arr.length*(arr.length-1))/2];
        int x = 0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                brr[x++] = arr[i]*arr[j];
            }
        }
        int ans = 0;
        Arrays.sort(brr);
        int i=0;
        while(i<brr.length)
        {
            int c=1;
            while(i<brr.length-1 && brr[i]==brr[i+1])
            {
                c++;
                i++;
            }
            ans += c*(c-1)/2;
            i++;
        }
        return 8*ans;
    }
}