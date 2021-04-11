// https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/1149810/Python3-and-Java-solutions-Replace-characters
import java.util.*;
class Solution
{
    public boolean isAlienSorted(String[] words, String order)
    {
        Map<Character, Character> map = new HashMap<>();
        int k=0;
        for(char c : order.toCharArray())
        {
            map.put(c, (char)(k+'a'));
            k++;
        }
        StringBuilder prev = new StringBuilder("");
        for(String w : words)
        {
            StringBuilder cur = new StringBuilder("");
            for(char c : w.toCharArray())
            {
                cur.append(map.get(c));    // Build the current word using the map
            }
            if(cur.compareTo(prev)<0)  // words will be sorted if current word is lexicographically greater than previous word
            {
                return false;
            }
            prev = cur;     // when you check the next word, you should know the current word as previous word
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        System.out.println("Enter number of test cases: ");
        int t = sc.nextInt();
        while(t-->0)
        {
            System.out.println("Enter number of words: ");
            int n = sc.nextInt();
            String[] words = new String[n];
            System.out.println("Enter words (space separated): ");
            for(int i=0; i<n; i++)
            {
                words[i] = sc.next();
            }
            System.out.println("Enter order consisting of all characters a-z in lowercase: ");
            String order = sc.next();
            System.out.println(ob.isAlienSorted(words, order));
        }
        sc.close();
    }
}