// https://leetcode.com/problems/zigzag-conversion/discuss/1160761/Java-using-StringBuilder-array
import java.util.*;
class Solution
{
    public String convert(String S, int r)
    {
        if(r==1 || r>=S.length()) return S;   // If r=1, everything will be in the first and only row and in order.
		                                                       // If r>=len(S) then everything will be in order in different rows.
        char[] s = S.toCharArray();              // char[] traversal faster.
        StringBuilder[] mat = new StringBuilder[r];   // StringBuilder much faster than String
        for(int i=0; i<r; i++)
            mat[i] = new StringBuilder("");                 // Initialize StringBuilder array
        int i=0, row=0, n=s.length;
        while(i<n)
        {
            while(row<r && i<n)
                mat[row++].append(s[i++]);           // Fill top to down
            row-=2;
            while(row>0 && i<n)                         // Fill bottom to up
                mat[row--].append(s[i++]);
        }
        for(i=1; i<r; i++)
            mat[0].append(mat[i]);    // Concatenate result
        return new String(mat[0]);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        System.out.println(ob.convert(sc.nextLine(), sc.nextInt()));
        sc.close();
    }
}
