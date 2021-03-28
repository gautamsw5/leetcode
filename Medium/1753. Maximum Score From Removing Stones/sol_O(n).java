class Solution
{
    public int maximumScore(int a, int b, int c)
    {
        int ans = 0;
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        while(arr[1]>0)
        {
            arr[1]--;
            arr[2]--;
            ans++;
            Arrays.sort(arr);
        }
        return ans;
    }
}