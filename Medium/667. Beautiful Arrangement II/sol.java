// Studied the pattern based on expected i/o on leetcode.
import java.util.*;
class Solution
{
    public int[] constructArray(int n, int k)
    {
        int[] arr = new int[n];
        int i = 1, j = k+1, p = 0;
        while(i<=j)
        {
            arr[p++] = i++;
            if(i<j)
            {
                arr[p++] = j--;
            }
        }
        for(i=k+2; i<=n; i++)
        {
            arr[p++] = i;
        }
        return arr;
    }
    public boolean check(int[] arr, int n, int k)
    {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n-1; i++)
        {
            set.add(Math.abs(arr[i]-arr[i+1]));
        }
        return set.size()==k;
    }
    public static void main(String[] args)
    {
        Solution ob = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(Arrays.toString(ob.constructArray(n, k)));
        sc.close();
        // outer:
        // for(int n=2; true; n++)
        // {
        //     for(int k=1; k<n-1; k++)
        //     {
        //         int[] arr = ob.constructArray(n, k);
        //         if(!ob.check(arr, n,k))
        //         {
        //             System.out.println("Wrong for: "+n+" "+k);
        //             System.out.println(Arrays.toString(arr));
        //             break outer;
        //         }
        //     }
        // }
    }
}