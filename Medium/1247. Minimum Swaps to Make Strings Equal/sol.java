class Solution
{
    public int minimumSwap(String s1, String s2)
    {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int x1 = 0,
        x2 = 0,
        y1 = 0,
        y2 = 0,
        i=0;
        Set<Integer> Ax = new HashSet<>();
        Set<Integer> Bx = new HashSet<>();
        for(char c:a)
        {
            if(c=='x')
            {
                x1++;
                Ax.add(i);
            }
            else
            {
                y1++;
            }
            i++;
        }
        i=0;
        for(char c:b)
        {
            if(c=='x')
            {
                x2++;
                if(Ax.contains(i))
                {
                    Ax.remove(i);
                }
                else
                {
                    Bx.add(i);
                }
            }
            else
            {
                y2++;
            }
            i++;
        }
        if((x1+x2)%2==1 || (y1+y2)%2==1 || a.length!=b.length)
        {
            return -1;
        }
        int ans = 0;
        // while(Ax.size()>1 || Bx.size()>1)
        // {
        //     if(Ax.size()>1)
        //     {
        //         int x = -1;
        //         for(int v:Ax)
        //         {
        //             x=v;
        //             break;
        //         }
        //         Ax.remove(x);
        //         x = -1;
        //         for(int v:Ax)
        //         {
        //             x=v;
        //             break;
        //         }
        //         Ax.remove(x);
        //         ans++;
        //     }
        //     if(Bx.size()>1)
        //     {
        //         int x = -1;
        //         for(int v:Bx)
        //         {
        //             x=v;
        //             break;
        //         }
        //         Bx.remove(x);
        //         x = -1;
        //         for(int v:Bx)
        //         {
        //             x=v;
        //             break;
        //         }
        //         Bx.remove(x);
        //         ans++;
        //     }
        // }
        // if(Ax.size()==1 && Bx.size()==1)
        // {
        //     ans += 2;
        // }
        int ax = Ax.size(),
        bx = Bx.size();
        if(ax%2==1 && bx%2==1)
        {
            ans += 2;
        }
        ans += ax/2 + bx/2;
        return ans;
    }
}