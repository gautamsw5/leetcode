class Solution
{
    public int kthSmallest(int[][] mat, int k)
    {
        int n = mat.length,
        m = mat.length,
        j=0;
        int[] arr = new int[n*n];
        for(int i=0; i<n; i++)
        {
            for(int x=0; x<m; x++)
            {
                arr[j++] = mat[i][x];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}