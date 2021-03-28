class Solution
{
    public int findUnsortedSubarray(int[] arr)
    {
        int[] brr = arr.clone();
        Arrays.sort(brr);
        int i=0;
        while(i<arr.length && arr[i]==brr[i]) i++;
        int j=arr.length-1;
        while(j>=0 && arr[j]==brr[j]) j--;
        return Math.max(0,j-i+1);
    }
}