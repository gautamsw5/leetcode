class Solution
{
    private boolean online(int[] a, int[] b, int[] c)
    {
        if(a[1]-b[1]!=0 && b[1]-c[1]!=0 && (1.0*a[0]-1.0*b[0])/(1.0*a[1]-1.0*b[1]) == (1.0*c[0]-1.0*b[0])/(1.0*c[1]-1.0*b[1]))
        {
            return true;
        }
        if(a[0]-b[0]!=0 && b[0]-c[0]!=0 && (1.0*a[1]-1.0*b[1])/(1.0*a[0]-1.0*b[0]) == (1.0*c[1]-1.0*b[1])/(1.0*c[0]-1.0*b[0]))
        {
            return true;
        }
        return false;
    }
    private boolean online(Pair<Integer,Integer> a, Pair<Integer,Integer> b, Pair<Integer,Integer> c)
    {
        if(a.getValue()-b.getValue()!=0 && b.getValue()-c.getValue()!=0 && ((double)a.getKey()-(double)b.getKey())/((double)a.getValue()-(double)b.getValue()) == ((double)c.getKey()-(double)b.getKey())/((double)c.getValue()-(double)b.getValue()))
        {
            return true;
        }
        if(a.getKey()-b.getKey()!=0 && b.getKey()-c.getKey()!=0 && ((double)a.getValue()-(double)b.getValue())/((double)a.getKey()-(double)b.getKey()) == ((double)c.getValue()-(double)b.getValue())/((double)c.getKey()-(double)b.getKey()))
        {
            return true;
        }
        return false;
    }
    public int maxPoints(int[][] points)
    {
        if(points.length<2)
        {
            return points.length;
        }
        int m=0;
        Map<Pair<Integer,Integer>,Integer> freq = new HashMap<>();
        for(int i=0;i<points.length;i++)
        {
            Pair p = new Pair(points[i][0],points[i][1]);
            freq.put(p,freq.getOrDefault(p,0)+1);
        }
        for(Pair p1 : freq.keySet())
        {
            for(Pair p2 : freq.keySet())
            {
                int c=freq.get(p1);
                if(!p1.equals(p2))
                {
                    c=c+freq.get(p2);
                    for(Pair p3 : freq.keySet())
                    {
                        if(!p1.equals(p2) && !p1.equals(p3) && !p3.equals(p2) && online(p1,p2,p3) && online(p2,p1,p3))
                        {
                            c+=freq.get(p3);
                        }
                    }
                }
                if(c>m)
                {
                    m=c;
                }
            }
        }
        return m;
    }
}