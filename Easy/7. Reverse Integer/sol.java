import java.util.Scanner;
class Solution
{
    public int reverse(int x)
    {
        int n = 0;
        while(x!=0)
        {
            if(n>Integer.MAX_VALUE/10 || (n==Integer.MAX_VALUE/10 && x%10>7))   // Check +ve overflow
                return 0;
            if(n<Integer.MIN_VALUE/10 || (n==Integer.MIN_VALUE/10 && (-x)%10>8)) // Check -ve overflow
                return 0;
            n = n*10 + x%10;
            x = x/10;
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        int x = sc.nextInt();
        System.out.println(ob.reverse(x));
        sc.close();
    }
}