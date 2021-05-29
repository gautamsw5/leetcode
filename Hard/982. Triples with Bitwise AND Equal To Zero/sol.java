// https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/discuss/1154502/Java-dp-O(n*max(A)-%2B-n*n)
import java.util.*;
// Find number of ordered triplets (i,j,k) in array A such that   A[i] & A[j] & A[k] = 0
// any of i,j,k may be used once or more than once in the same triplet.
// (0,0,0)   (0,0,1)   (1,0,2)  are valid triplets.
//  (0,0,1)   and    (0,1,0)     and     (1,0,0)    count as different triplets.
class Solution
{
    public int countTriplets(int[] A)
    {
        int ans = 0, n=A.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> pairs = new HashMap<>(); // Keys -> each possible pairwise AND
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                dp[i][j] = A[i] & A[j];
                pairs.put(dp[i][j], 0);
            }
        }
        for(int i : pairs.keySet())   // Length of key set <= max(A) because all pairwise AND will give number <= max(A)
        {
            for(int k=0; k<n; k++)
            {
                if((i&A[k])==0)
                {
                    pairs.put(i, pairs.getOrDefault(i,0)+1); // Count for each possible pairwise AND,
                                                             // how many numbers in A can make it 0 on AND operation
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                ans += pairs.getOrDefault(dp[i][j],0);  // Just add the pre-computed result, i.e. number of i,j,k e [0,n) such that,
                                                        // A[i] & A[j] & A[k]  =  0
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Solution ob = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(ob.countTriplets(arr));
        sc.close();
    }
}