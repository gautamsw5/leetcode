class Solution {
public:
    bool isNumber(string s)
    {
        using namespace std;
        int ef=0,df=0,mf=0,i=0,j=s.length()-1;
        if(s=="")
            return false;
        while(i<j && s[i]==' ')
        {
            i++;
        }
        if(i==j+1)
        return false;
        while(j>=0 && s[j]==' ')
        {
            j--;
        }
        if(j==-1)
        return false;
        if(s[i]=='.')
        {
            df=1;
            i=i+1;
        }
        if(i==j+1)
            return false;

        if(i>0 && ((s[i-1]=='.' && s[i]=='-') || (s[i-1]=='.' && s[i]=='+')))
            return false;
        if(i==j-1 && ((s[i+1]=='.' && s[i]=='+') || (s[i+1]=='.' && s[i]=='-')))
            return false;
        if(i<j && (s[i]=='-' && s[i+1]=='e'))
            return false;
        if(s[i]=='e' || s[i]=='.' || s[j]=='e' || s[j]=='+' || s[j]=='-')
            return false;
        if(s[i]=='+' || s[i]=='-')
            i=i+1;

        if(i==j+1)
            return false;
        while(i<j+1)
        {
            if(isdigit(s[i]))
            {
                mf=1;
                i=i+1;
                continue;
            }
            if((s[i-1]=='e' && s[i]=='.') || (s[i-1]=='.' && s[i]=='-') || (s[i-1]=='.' && s[i]=='+'))
                return false;
            if(s[i]=='e')
            {
                if(ef==1)
                    return false;
                if(ef==0)
                {
                    if(s[i+1]=='+' || s[i+1]=='-')
                        i=i+1;
                    df=1;
                    ef=1;
                }
            }
            else if(s[i]=='.')
            {
                if(df==1)
                    return false;
                if(df==0)
                    df=1;
            }
            else
                return false;
            i=i+1;
        } 
        return true;
    }
};