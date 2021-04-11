import java.util.*;
class HALVESALIKE
{
    private boolean isVov(char c)
    {
        return c=='A' || c=='E' || c=='O' || c=='U' || c=='a' || c=='e' || c=='o' || c=='u' || c=='I' || c=='i';
    }
    public boolean halvesAreAlike(String S)
    {
        char[] s = S.toCharArray();   // char[] is faster than String for traversal
        int i=0;
        int x=0;
        while(i<s.length/2)          // First half add count to x
        {
            if(isVov(s[i]))
            {
                x++;
            }
            i++;
        }
        while(i<s.length)           // Second half remove count from x
        {
            if(isVov(s[i]))
            {
                x--;
            }
            i++;
        }
        return x==0;               // At the end if x is 0 then equal vowels on both sides
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HALVESALIKE ob = new HALVESALIKE();
        int t = sc.nextInt();
        for(int i=0; i<t; i++)
        {
            String s = sc.next();
            System.out.println(ob.halvesAreAlike(s));
        }
        sc.close();
    }
}