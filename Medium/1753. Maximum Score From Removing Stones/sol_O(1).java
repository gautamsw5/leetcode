class Solution
{
    public int maximumScore(int a, int b, int c)
    {
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int ans = b-a;
        b = b - ans; // b = a
        c = c - ans;
        if(c>=2*a)
        {
            return ans + 2*a;
        }
        return ans + a + c/2;
    }
}