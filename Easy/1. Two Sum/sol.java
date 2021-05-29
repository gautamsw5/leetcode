// https://leetcode.com/problems/two-sum/discuss/1159476/Java-two-solutions-one-using-map-other-using-sort-O(n*log(n))
import java.util.*;
class Solution
{
    public int[] twoSumUsingMap(int[] arr, int target) // Using HashMap  -- O(n*log(n))
    {
        Map<Integer, Integer> map = new HashMap<>(); // key-> element, value-> index in arr
        for(int i=0; i<arr.length; i++)
        {
            if(map.containsKey(target-arr[i]))       // If any j<i and arr[j]+arr[i]=target, it will return [j,i]
            {
                return new int[]{map.get(target-arr[i]), i};
            }
            map.put(arr[i], i);                      // Set index of current element. This i could be used as a j for other greater i's
        }
        return new int[]{};
    }
    public int[] twoSumSortandSearch(int[] arr, int target) // Using sort and binary search -- O(n*log(n))
    {
        int[][] xrr = new int[arr.length][2];   // xrr[i][0] = element, xrr[i][1] = original index in arr
        for(int i=0; i<arr.length; i++)
        {
            xrr[i][0] = arr[i];                 // Store element
            xrr[i][1] = i;                      // Store its index
        }
        Arrays.sort(xrr, (a,b)->a[0]-b[0]);   // Sort using comparator
        for(int i=0; i<xrr.length; i++)
        {
            int l = i+1, r = xrr.length-1;
            while(l<=r)                         // Binary search for xrr[m][0] = target-xrr[i][0]  on  xrr, i+1, n-1  (i+1 to avoid using same element twice.)
            {
                int m = (r+l)/2;
                if(xrr[m][0]==target-xrr[i][0])  // If found, return
                {
                    return new int[]{xrr[i][1],xrr[m][1]};
                }
                else if(xrr[m][0]<target-xrr[i][0])       // If middle < target, target will not occur to the left of middle, so increase l = m+1
                {
                    l = m+1;
                }
                else                                      // If middle > target, target will not occur to the right of middle, so decrease r = m-1
                {
                    r = m-1;
                }
            }
        }
        return new int[]{};
    }
    public int[] twoSum(int[] arr, int target)
    {
        return twoSumUsingMap(arr, target);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(ob.twoSum(arr, target)));
        sc.close();
    }
}