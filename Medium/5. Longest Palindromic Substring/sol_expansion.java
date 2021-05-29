// https://leetcode.com/problems/longest-palindromic-substring/discuss/1160963/Java-Expand-around-centers-faster-than-97.6
import java.util.*;
class Solution
{
    public String longestPalindrome(String S)
    {
        char[] s = S.toCharArray();
        int n = s.length;
        int left = 0, right = 0;  // left end and right end of answer
        for(int i=0;i<n;i++)
        {
            int r=i, l=i; // Find longest palindrome with s[i] at center
            while(l-1>=0 && r+1<n && s[l-1]==s[r+1]) // Expand around center
            {
                l--;
                r++;
            }
            if(r-l>right-left)  // Update result if larger found
            {
                left = l;
                right = r;
            }
            if(i+1<n && s[i]==s[i+1])   // Find longest palindrome with s[i], s[i+1] at center
            {
                l=i;
                r=i+1;
                while(l-1>=0 && r+1<n && s[l-1]==s[r+1])  // Expand around center
                {
                    l--;
                    r++;
                }
                if(r-l>right-left)  // Update result if larger found
                {
                    left=l;
                    right=r;
                }
            }
        }
        return S.substring(left,right+1);  // s[left....right]
    }
    public static void main(String[] args)
    {
        Solution ob = new Solution();
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(ob.longestPalindrome(S));
        sc.close();
    }
}