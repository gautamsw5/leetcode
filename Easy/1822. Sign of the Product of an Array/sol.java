// https://leetcode.com/problems/sign-of-the-product-of-an-array/discuss/1153752/Java-O(n)-0ms-faster-than-100
import java.util.Scanner;
class Solution
{
    public int arraySign(int[] arr)
    {
        int pc=0, nc=0, zc=0; // Counters for positive, negative, and zero numbers in arr. 
        for(int i : arr)
        {
            if(i>0)
            {
                pc++; // Positive
            }
            else if(i==0)
            {
                zc++; // Zero
            }
            else
            {
                nc++; // Negative
            }
        }
        if(zc>0)  // Multiply any number of +ve and any number of -ve numbers with 0 to get 0 again.
        {
            return 0;
        }
        if(nc%2==1) // If odd number of negative numbers are multiplied with any number of positive numbers, result will be negative (basic math)
        {
            return -1;
        }
        return 1; // If its not 0 not -ve then it would be +ve.
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
        System.out.println(ob.arraySign(arr));
        sc.close();
    }
}