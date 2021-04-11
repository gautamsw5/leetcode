// https://leetcode.com/problems/minimum-operations-to-make-array-equal/discuss/904673/Java-one-line-solution-0-ms
import java.util.*;
class Solution
{
    public int minOperations(int n)
    {
        int ans = 0;
        for(int i=0; i<n; i++)
        {
           ans += Math.abs(2*i+1-n);   // either add or remove, count both.
        }
        return ans/2;  // whichever removed from somehere also got added somewhere else so counted twice.
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        int n = sc.nextInt();
        System.out.println(ob.minOperations(n));
        sc.close();
    }
}