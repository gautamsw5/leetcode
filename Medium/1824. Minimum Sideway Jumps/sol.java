// https://leetcode.com/problems/minimum-sideway-jumps/discuss/1153673/Java-Recursion-and-Memo
// i -> 0 indexed x coordinate
// j -> 0 indexed y coordinate
// arr[i] = j   ==>  There is an obstacle at point (i,j)
// arr[i] = -1  ==>  There is no obstacle at x = i
import java.util.*;
class Solution
{
    int[][] minJumps;  // Memo to store min jumps required from (i,j)
    int[] arr;         // Input
    int n;             // length of arr
    int solve(int i, int j)
    {
	    if(i>=n-1)    // If i>=n-1, you have reached or crossed the last point (here n is taken as length of the array).
            return 0;
        if(i<0 || j<0 || j>2 || arr[i]==j)  // base cases, out of bounds or land on obstacle (so not a valid path and hence return max_value).
            return 1000000;
        if(minJumps[i][j]!=1000000)   // If min jumps from (i,j) already known simply return it.
            return minJumps[i][j];
		// Moving towards +ve x
        if(i+1<n && arr[i+1]!=j)      // Moving right possible if one to the right of current point is not an obstacle.
            minJumps[i][j] = Math.min(minJumps[i][j], solve(i+1,j));
        // Below are different cases of moving up and down on the same x coordinate by 1 or 2 units based on only condition that do not land on obstacle.
        if(j==0)    // point has y coordinate = 0
        {
            if(arr[i]!=1)   // If y = 1 on the same x coordinate is not an obstacle, jump is allowed
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,1) + 1);
            if(arr[i]!=2)   // If y = 2 on the same x coordinate is not an obstacle, jump is allowed
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,2) + 1);
        }
		else if(j==1)  // point has y coordinate = 1
        {
            if(arr[i]!=0)  // If y = 0 on the same x coordinate is not an obstacle, jump is allowed
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,0) + 1);
            if(arr[i]!=2)  // If y = 2 on the same x coordinate is not an obstacle, jump is allowed
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,2) + 1);
        }
        else if(j==2)   // point has y coordinate = 2
        {
            if(arr[i]!=1)  // If y = 1 on the same x coordinate is not an obstacle, jump is allowed
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,1) + 1);
            if(arr[i]!=0)  // If y = 0 on the same x coordinate is not an obstacle, jump is allowed
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,0) + 1);
        }
        return minJumps[i][j];  // Return answer stored as minimum of all possible cases.
    }
    public int minSideJumps(int[] arr)
    {
        this.n = arr.length;
        this.arr = arr;
        this.minJumps = new int[n][3];
        for(int i=0; i<n; i++)
        {
            this.arr[i] -= 1;
            this.minJumps[i][0] = 1000000;
            this.minJumps[i][1] = 1000000;
            this.minJumps[i][2] = 1000000;
        }
        return solve(0,1);
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
        System.out.println(ob.minSideJumps(arr));
        sc.close();
    }
}