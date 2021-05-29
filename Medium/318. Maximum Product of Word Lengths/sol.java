import java.util.Scanner;

class Solution
{
    public int maxProduct(String[] words)
    {
        int ans = 0;
        int[] masks = new int[words.length];
        for(int i=0; i<words.length; i++)
        {
            for(char c : words[i].toCharArray())
            {
                masks[i] |= 1<<(c - 'a');
            }
        }
        for(int i=0; i<words.length; i++)
            for(int j=i+1; j<words.length; j++)
                if((masks[i] & masks[j])==0 && ans<words[i].length()*words[j].length())
                    ans = words[i].length()*words[j].length();
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0; i<n; i++)
            words[i] = sc.next();
        Solution ob = new Solution();
        System.out.println(ob.maxProduct(words));
        sc.close();
    }
}