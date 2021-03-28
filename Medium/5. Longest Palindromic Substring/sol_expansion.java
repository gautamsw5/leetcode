class Solution
{
    public String longestPalindrome(String S)
    {
        char[] s = S.toCharArray();
        int n = s.length;
        int l = 0,
        r = 0;
        for(int i=0;i<n;i++)
        {
            int a=i,
            b=i;
            while(a>=0 && b<n && s[a]==s[b])
            {
                a--;
                b++;
            }
            a++;
            b--;
            if(b-a+1>r-l+1)
            {
                l=a;
                r=b;
            }
            a=i;
            b=i+1;
            while(a>=0 && b<n && s[a]==s[b])
            {
                a--;
                b++;
            }
            a++;
            b--;
            if(b-a+1>r-l+1)
            {
                l=a;
                r=b;
            }
        }
        return S.substring(l,r+1);
    }
}