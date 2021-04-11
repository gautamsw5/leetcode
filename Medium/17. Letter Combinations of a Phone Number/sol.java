import java.util.*;
class LetterComb
{
    char[][] arr;
    char[] dig;
    List<String> ans;
    void solve(int idx, String cur)
    {
        if(idx==dig.length)    // When one letter from every digit has been picked
        {
            ans.add(cur);      // Add to solution
            return;            // Pop from recursion stack
        }
        for(char c : arr[dig[idx]-'2'])  // Current index of result has all choices corresponding to the digit at current index (idx)
        {
            solve(idx+1, cur + c);      //  Solve for next index using recursion
        }
    }
    public List<String> letterCombinations(String digits)
    {
        if(digits.length()==0)
        {
            return new ArrayList<String>();
        }
        dig = digits.toCharArray();
        arr = new char[][]{{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
        ans = new ArrayList<>();
        solve(0, "");
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        LetterComb ob = new LetterComb();
        for(int i=0; i<t; i++)
        {
            System.out.println(ob.letterCombinations(sc.next()));
        }
        sc.close();
    }
}