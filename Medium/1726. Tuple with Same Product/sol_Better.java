class Solution
{
    public int tupleSameProduct(int[] arr)
    {
        Map<Integer,Integer> dct = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                dct.put(arr[i]*arr[j],dct.getOrDefault(arr[i]*arr[j],0)+1);
            }
        }
        int ans = 0;
        for(int i : dct.keySet())
        {
            int n = dct.get(i);
            ans += 4*n*(n-1);
        }
        return ans;
    }
}