// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/1151145/Java-recursive-memo
import java.util.*;
class Solution
{
    Integer[][] dp;     // Let z =  length of longest path starting at (i,j). Store z-1 in dp[i][j]
    int pathLength(int[][] arr, int x, int y)
    {
        if(x>=arr.length || y>=arr[x].length) // Going out of boundary not allowed.
        {
            return 0;
        }
        if(dp[x][y]!=null)  // If length of longest path starting at (i,j) already calculated,
                            // no need to calculate again just return the answer.
        {
            return dp[x][y];
        }
        int a=0, b=0, c=0, d=0;  // a,b,c,d handle all four cases up, down, left, right.
        if(x>0 && arr[x-1][y]>arr[x][y])
        {
            dp[x-1][y] = pathLength(arr, x-1, y); // Max path length starting at (x-1, y) stored in dp[x-1][y]
            a = 1 + dp[x-1][y];  // a represents path starting at dp[x][y]. If arr[x-1][y]>arr[x][y], then
                                 // this path's length is length of longest path starting at (x-1,y)+1 
        }
        if(x+1<arr.length && arr[x+1][y]>arr[x][y])
        {
            dp[x+1][y] = pathLength(arr, x+1, y);
            b = 1 + dp[x+1][y];
        }
        if(y>0 && arr[x][y-1]>arr[x][y])
        {
            dp[x][y-1] = pathLength(arr, x, y-1);
            c = 1 + dp[x][y-1];
        }
        if(y+1<arr[x].length && arr[x][y+1]>arr[x][y])
        {
            dp[x][y+1] = pathLength(arr, x, y+1);
            d = 1 + dp[x][y+1];
        }
        return Math.max(a,Math.max(b,Math.max(c,d))); // Answer is maximum of all 4 possible paths.
    }
    public int longestIncreasingPath(int[][] matrix)
    {
        int ans = 0;
        dp = new Integer[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                ans = Math.max(ans, pathLength(matrix, i, j));
            }
        }
        return ans+1;    //  See the 1st line z-1 stored in dp[i][j].
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        System.out.println("Enter number of test cases: ");
        int t = sc.nextInt();
        for(int k=0; k<t; k++)
        {
            System.out.println("Enter number of rows: ");
            int n = sc.nextInt();
            System.out.println("Enter number of columns: ");
            int m = sc.nextInt();
            System.out.println("Enter the elements of the matrix (rowise): ");
            int[][] matrix = new int[n][m];
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++)
                {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("Length of longest increasing path is: "+ob.longestIncreasingPath(matrix));
        }
        sc.close();
    }
}