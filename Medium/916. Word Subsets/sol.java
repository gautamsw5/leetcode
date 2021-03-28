class Solution
{
    public List<String> wordSubsets(String[] A, String[] B)
    {
        int[][] a = new int[A.length][26];
        int[] b = new int[26];
        int[] c;
        for(int i=0; i<A.length; i++)
        {
            for(char j:A[i].toCharArray())
            {
                a[i][j-'a']++;
            }
        }
        for(int i=0; i<B.length; i++)
        {
            c = new int[26];
            for(char j:B[i].toCharArray())
            {
                c[j-'a']++;
            }
            for(int j=0; j<26; j++)
            {
                if(b[j]<c[j]) b[j] = c[j];
            }
        }
        List<String> ret = new ArrayList<>();
        outer:
        for(int i = 0; i < A.length; i++)
        {
            for(int j=0;j<26;j++)
            {
                if(b[j]>a[i][j]) continue outer;
            }
            ret.add(A[i]);
        }
        return ret;
    }
}