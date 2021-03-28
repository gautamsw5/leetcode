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
        boolean[] set = new boolean[sum+1];
        boolean[] next = new boolean[sum+1];
        set[0] = true;   // if empty arr
        for(int i : arr)
        {
            for(int s=0;s<=sum;s++) next[s] = set[s];  // next = new HashSet<>(set);
            if(i<=sum) next[i]=true; // next.add(arr[i]);
            for(int s=0;s<=sum;s++) // for(int x:set)
            {
                if(s+i<=sum && set[s]) next[s+i]=true;  // next.add(x+arr[i]);
            }
            for(int s=0;s<=sum;s++) set[s] = next[s]; // set = next;
        }
        return set[sum];
    }
}