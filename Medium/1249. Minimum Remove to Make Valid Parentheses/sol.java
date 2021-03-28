class Solution
{
    public String minRemoveToMakeValid(String S)
    {
        char[] s = S.toCharArray();
        int i=0;
        while(i<s.length)
        {
            if(s[i]=='(')
            {
                int x = 0;
                while(i<s.length)
                {
                    if(s[i]=='(')
                    {
                        x++;
                    }
                    else if(s[i]==')')
                    {
                        x--;
                        if(x==-1)
                        {
                            s[i]='\0';
                            x++;
                        }
                    }
                    i++;
                }
            }
            else if(s[i]==')')
            {
                s[i] = '\0';
                i++;
            }
            else
            {
                i++;
            }
        }
        i=s.length-1;
        while(i>=0)
        {
            if(s[i]==')')
            {
                int x = 0;
                while(i>=0)
                {
                    if(s[i]==')')
                    {
                        x++;
                    }
                    else if(s[i]=='(')
                    {
                        x--;
                        if(x==-1)
                        {
                            s[i]='\0';
                            x++;
                        }
                    }
                    i--;
                }
            }
            else if(s[i]=='(')
            {
                s[i] = '\0';
                i--;
            }
            else
            {
                i--;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(char c:s)
        {
            if(c!='\0')
            sb.append(c);
        }
        return new String(sb);
    }
}