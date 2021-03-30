// https://leetcode.com/problems/russian-doll-envelopes/discuss/1134381/Java-O(n2)
class RussionEnvelope
{
    public int maxEnvelopes(int[][] arr)
    {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[0]*a[1]-b[0]*b[1];
            }
        });
        int[] length = new int[n]; Arrays.fill(length,1);
        Integer[] prev = new Integer[n]; //System.out.println(Arrays.deepToString(arr));
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(arr[j][0]<arr[i][0] && arr[j][1]<arr[i][1])
                {
                    if(prev[i]==null)
                    {
                        prev[i] = j;
                        length[i]++;
                    }
                    else if(length[j]>length[prev[i]])
                    {
                        length[i] = length[j]+1;
                        prev[i] = j;
                    }
                }
            }
        }
        int ans = 0; for(int i : length) if(i>ans) ans = i;      return ans;
    }
}