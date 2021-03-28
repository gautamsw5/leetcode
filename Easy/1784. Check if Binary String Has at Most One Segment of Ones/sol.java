class Solution
{
    public boolean checkOnesSegment(String S)
    {
        char[] s = S.toCharArray();
        int i = 0;
        while(i<s.length && s[i]=='0')
        {
            i++;
        }
        while(i<s.length && s[i]=='1')
        {
            i++;
        }
        while(i<s.length && s[i]=='0')
        {
            i++;
        }
        return i==s.length;
    }
}