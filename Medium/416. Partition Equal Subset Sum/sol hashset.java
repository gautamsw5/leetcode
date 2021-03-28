class Solution
{
    public boolean canPartition(int[] arr)
    {
        int sum = 0;
        for(int i:arr)
        {
            sum += i;
        }
        if(sum%2==1) return false;
        sum /= 2;
        Set<Integer> set = new HashSet<>();
        Set<Integer> next;
        int i=0;
        while(!set.contains(sum) && i<arr.length)
        {
            next = new HashSet<>(set); // create a copy of 'set'
            next.add(arr[i]);
            for(int x:set)
            {
                next.add(x+arr[i]); // used next so tha set is not changed during traversal
            }
            set = next;
            i++;
        }
        return set.contains(sum);
    }
}