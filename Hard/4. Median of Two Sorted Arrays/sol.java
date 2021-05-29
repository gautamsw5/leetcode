// O(n+m) time,  O(1) space
import java.util.*;
class Solution
{
    public int get(int[] arr, int[] brr, int n, int m, int k)  // Similar to merge of mergesort, to get element at 
    {                                                          // index = k in the merge of arr and brr using constant space and O(k) time.
        int i=0, j=0, ans = -1;
        while(i<n && j<m && k>-1)
        {
            if(arr[i]<brr[j])
            {
                ans = arr[i++];
            }
            else
            {
                ans = brr[j++];
            }
            k--;
        }
        while(i<n && k>-1)
        {
            ans = arr[i++];
            k--;
        }
        while(j<m && k>-1)
        {
            ans = brr[j++];
            k--;
        }
        return ans;
    }
    public double findMedianSortedArrays(int[] arr, int[] brr)
    {
        int n = arr.length, m = brr.length;
        if((n+m)%2==1)  // If odd total length middle element is median
        {
            return 1.0*get(arr, brr, n, m, (n+m)/2);
        }
        else  // Oterwise average of middle two elements
        {
            return (get(arr, brr, n, m, (n+m)/2-1)+get(arr, brr, n, m, (n+m)/2))/2.0;
        }
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
        int m = sc.nextInt();
        int[] brr = new int[m];
        for(int i=0; i<m; i++)
        {
            brr[i] = sc.nextInt();
        }
        System.out.println(ob.findMedianSortedArrays(arr, brr));
        sc.close();
    }
}