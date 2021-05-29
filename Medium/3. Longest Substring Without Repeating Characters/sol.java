import java.util.*;
class Solution
{
    // Optimized bruteforce O(66*n)
    public int lengthOfLongestSubstringBruteForce(String S)  //  O(n*m) -> m is number of allowed characters, here, m = 66
    {
        char[] s = S.toCharArray();            // char[] traversal faster
        Set<Character> set = new HashSet<>();  // Set of used characters
        int ans = 0, i=0, j=0;
        for(i=0; i<s.length; i++)              // Find longest valid substring starting at all i and get the max length
        {
            set = new HashSet<>();
            for(j=i; j<s.length+1; j++)        // Start at i, keep adding characters until end or repeated character found.
            {
                if(j==s.length || set.contains(s[j]))
                {
                    ans = Math.max(ans, j-i);   // j-i is the length of longest valid substring starting at i.
                    break;
                }
                set.add(s[j]);
            }
        }
        return ans;
    }
    // Two pointer O(n)
    public int lengthOfLongestSubstring(String S)   // O(n*log(m))  m <= 66, so O(n)
    {
        char[] s = S.toCharArray();            // char[] traversal faster
        Set<Character> set = new HashSet<>();  // Set of used characters
        int ans = 0, i=0, j=0;                 // i-> start point of a valid substring, j-> its endpoint
        while(i<s.length)
        {
            while(j<s.length)                  // move endpoint towards right until current substring is valid.
            {
                if(set.contains(s[j]))
                {
                    break;    // Now substring [i,j] is invalid so break and next thing to do is to shift i (which is the start point).
                              // It is invalid such that substring [i,j-1] is valid and s[j] occurs in substring [i,j-1]
                }
                ans = Math.max(ans, j-i+1);  // substring [i,j] is valid so update ans
                set.add(s[j]);               // Add to set which helps in checking validity in O(1) time.
                j++;                         // Move endpoint (j) towards right.
            }
            if(j<s.length)   // Once the string has become invalid, move the start point towards right until it becomes valid again
                             // It will become valid when first occurence of s[j] is removed.
            {
                while(i<s.length && set.contains(s[j])) // Loop will run until substring [i,j] becomes valid.
                {
                    set.remove(s[i]);  // Remove s[i], because i will increment  and moving start towards right
                    i++;               // move start towards right
                }
            }
            else                             // j reached the end, increase i or decrease j, ans will remain same so stop.
            {
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        String s = sc.nextLine();
        System.out.println(ob.lengthOfLongestSubstring(s));
        sc.close();
    }
}