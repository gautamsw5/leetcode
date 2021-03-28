class Solution
{
    public long dec(String s)
    {
        long ret = 0;
        for(int i=0;i<s.length();i++)
        {
            ret = ret*2;
            if(s.charAt(i)=='1')
            {
                ret++;
            }
        }
        //System.out.println(s+" "+ret);
        return ret;
    }
    public boolean queryString(String S, int N)
    {
        long n = N;
        long s = 0;
        Set<Long> done = new HashSet<>();
        for(int i=0; i<S.length(); i++)
        {
            for(int j=i+1; j-i<33 && j<S.length()+1 ; j++)
            {
                long x = dec(S.substring(i,j));
                //System.out.println(S.substring(i,j)+" "+x);
                if(x<=n && !done.contains(x))
                {
                    //System.out.println(S.substring(i,j));
                    s += x;
                    done.add(x);
                }
            }
        }
        return s == (n*(n+1))/2;
    }
}