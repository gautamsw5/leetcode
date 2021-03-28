class Solution
{
    public int numberOfArithmeticSlices(int[] A)
    {
        int i=0,
        n=A.length,
        ans=0;
        while(i<n-1)
        {
            int d = A[i+1]-A[i],
            l=2;
            while(i<n-1 && A[i+1]-A[i]==d)
            {
                l++;
                i++;
            }
            if(l>2)
            {
                ans += ((l-2)*(l-3))/2;
            }
        }
        return ans;
    }
}