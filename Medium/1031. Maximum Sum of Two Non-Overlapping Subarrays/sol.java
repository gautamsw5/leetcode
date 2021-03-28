class Solution
{
    public int maxSumTwoNoOverlap(int[] A, int L, int M)
    {
        int[] a = new int[A.length-L+1];
        int[] b = new int[A.length-M+1];
        for(int i=0;i<L;i++)
        {
            a[0] += A[i];
        }
        for(int i=1; i<A.length-L+1;i++)
        {
            a[i] = a[i-1] - A[i-1] + A[L+i-1];
        }
        for(int i=0;i<M;i++)
        {
            b[0] += A[i];
        }
        for(int i=1; i<A.length-M+1;i++)
        {
            b[i] = b[i-1] - A[i-1] + A[M+i-1];
        }
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        int ans = 0;
        for(int s1 = 0; s1 < a.length; s1++)
        {
            for(int s2 = 0; s2 < b.length; s2++)
            {
                if(a[s1]+b[s2]>ans && (s1+L<=s2 || s2+M<=s1))
                {
                    ans = a[s1]+b[s2];
                }
            }
        }
        return ans;
    }
}