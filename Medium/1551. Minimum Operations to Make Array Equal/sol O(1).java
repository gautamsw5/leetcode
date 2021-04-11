// https://leetcode.com/problems/minimum-operations-to-make-array-equal/discuss/904673/Java-one-line-solution-0-ms
import java.util.*;
class Solution
{
    public int minOperations(int n)
    {
        return n%2==1?((n-1)*(n+1)/4):(n*n/4);
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