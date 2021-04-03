class LongestValidParentheses
{
    public int longestValidParentheses(String S)
    {
        char[] s = S.toCharArray();
        int ans = 0, n = s.length, c = 0;
        for(int j=0; j<n; j++)
        {
            int i=j;
            c=0;
            while(i<n)
            {
                if(s[i]=='(') c++;
                else if(s[i]==')') c--;
                if(c<0)
                {
                    i++;
                    break;
                }
                if(c==0 && ans<i-j+1) ans = i-j+1;
                i++;
            }
        }
        return ans;
    }
}