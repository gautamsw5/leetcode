// https://leetcode.com/problems/minimum-sideway-jumps/discuss/1153673/Java-Recursion-and-Memo
import java.util.*;
class Solution
{
    int[][] minJumps;  // Memo to store min jumps required from (i,j)
    int[] arr;         // Input
    int n;             // length of arr
    int solve(int i, int j)
    {
        if(i<0 || j<0 || i>=n || j>2 || arr[i]==j || i>=n-2)  // base cases, no obstacle on last lane so just reach n-2
            return 0;
        if(minJumps[i][j]!=1000000)   // If min jumps from (i,j) already known simply return it.
            return minJumps[i][j];
        if(i+1<n && arr[i+1]!=j)      // Move right if not obstacle.
            minJumps[i][j] = Math.min(minJumps[i][j], solve(i+1,j));
        // Below are different cases of moving up and down by 1 or 2 units based on only condition that do not land on obstacle.
        if(j==0)
        {
            if(arr[i]!=1)
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,1) + 1);
            if(arr[i]!=2)
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,2) + 1);
        }
        else if(j==2)
        {
            if(arr[i]!=1)
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,1) + 1);
            if(arr[i]!=0)
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,0) + 1);
        }
        else
        {
            if(arr[i]!=0)
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,0) + 1);
            if(arr[i]!=2)
                minJumps[i][j] = Math.min(minJumps[i][j], solve(i,2) + 1);
        }
        return minJumps[i][j];  // Return answer stored as minimum of all possible cases.
    }
    public int minSideJumps(int[] arr)
    {
        n = arr.length;
        this.arr = arr;
        minJumps = new int[n][3];
        for(int i=0; i<n; i++)
        {
            arr[i] -= 1;
            minJumps[i][0] = 1000000;
            minJumps[i][1] = 1000000;
            minJumps[i][2] = 1000000;
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