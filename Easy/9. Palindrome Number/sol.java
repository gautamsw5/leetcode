class Solution
{
    public boolean isPalindrome(int x)
    {
        int x_in = x, n = 0;
        while(x>0) // According to the question negative values are not palindrome.
        {
            if(n>Integer.MAX_VALUE/10 || (n==Integer.MAX_VALUE/10 && x%10>7))  // If reverse of x causes overflow, x is not palindrome, because x is input and it did not cause overflow.
            {
                return false;
            }
            n = n*10 + x%10;
            x = x/10;
        }
        return x_in==n;  // Reverse of number equal to input number or not.
    }
}