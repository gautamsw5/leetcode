class Solution
{
    public int tupleSameProduct(int[] arr)
    {
        Map<Integer,Set<Integer>> dct = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                int x = arr[i]*arr[j];
                if(!dct.containsKey(x))
                {
                    dct.put(x,new HashSet<>());
                }
                int a = Math.min(arr[i],arr[j]),
                b = Math.max(arr[i],arr[j]);
                dct.get(x).add(a*100000+b);
            }
        }
        int ans = 0;
        for(int i : dct.keySet())
        {
            int n = dct.get(i).size();
            ans += 4*n*(n-1);
        }
        return ans;
    }
}