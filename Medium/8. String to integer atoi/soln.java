class Solution
{
    public int myAtoi(String S)
    {
        char[] s = S.toCharArray();
        int ret = 0, intmax = Integer.MAX_VALUE, intmin = Integer.MIN_VALUE, i=0, n = s.length;
        while(i<n && s[i]==' ') i++;
        if(i<n)
        {
            int sign = 1;    // Store sign
            if(s[i]=='+')
            {
                i++;
            }
            else if(s[i]=='-')
            {
                sign=-1;
                i++;
            }
            if(sign==1)
            {
                while(i<n && s[i]>='0' && s[i]<='9')
                {
                    if(ret>intmax/10 || (ret==intmax/10 && s[i]>'7' && s[i]<='9'))  // Check overflow
                        return intmax;
                    ret = ret*10 + s[i]-'0';
                    i++;
                }
                return ret;
            }
            else
            {
                while(i<n && s[i]>='0' && s[i]<='9')
                {
                    if(ret>intmax/10 || (ret==intmax/10 && s[i]>'7' && s[i]<='9'))  // Check overflow
                        return intmin;
                    ret = ret*10 + s[i]-'0';
                    i++;
                }
                return -ret;
            }
        }
        return ret;
    }
}