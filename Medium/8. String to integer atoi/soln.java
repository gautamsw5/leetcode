class Solution {
    public int myAtoi(String s)
    {
        int sign=-1,started=0;
        long ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='-')
            {
                if(started==1)
                {
                    break;
                }
                sign=1;
            }
            else if(Character.isDigit(s.charAt(i)))
            {
                ans=10*ans-(s.charAt(i)-'0');
                started=1;
            }
            else if(s.charAt(i)!=' ' && s.charAt(i)!='+')
            {
                break;
            }
            if(s.charAt(i)==' ' && started==1)
            {
                break;
            }
            if(s.charAt(i)=='+' || s.charAt(i)=='-')
            {
                if(started==1)
                {
                    break;
                }
                if(i<s.length()-1)
                {
                    if(!Character.isDigit(s.charAt(i+1)))
                    {
                        break;
                    }
                }
            }
            if(ans<=-2147483648)
            {
                if(sign==1)
                {
                    return -2147483648;
                }
                else
                {
                    return 2147483647;
                }
            }
        }
        return sign*(int)ans;
    }
}