class WordFilter
{
    List<String> list;
    Map<String, Integer> map;
    public WordFilter(String[] words)
    {
        list = new ArrayList<>();
        map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            for(int j=1; j<=words[i].length(); j++)
            {
                String t = words[i].substring(words[i].length()-j,words[i].length())+"#"+words[i];
                if(!map.containsKey(t))
                {
                    list.add(t);
                }
                map.put(t, i);
            }
        }
        // System.out.println(list);
        Collections.sort(list, (a,b) -> a.compareTo(b));
        // for(pair p : list)
        //     System.out.println(p.s+" "+p.i);
    }
    public int f(String prefix, String suffix)
    {
        // return 0;
        String x = suffix+"#"+prefix;
        int l = 0, r = list.size(), s = -1;
        while(l<=r)
        {
            int m = (l+r)/2;
            if(list.get(m).compareTo(x) >= 0 && (m==0 || list.get(m-1).compareTo(x) < 0))
            {
                // System.out.println(m);
                int ret = -1;
                while(m<list.size() && list.get(m).startsWith(x))
                {
                    ret = Math.max(ret, map.get(list.get(m)));
                    m++;
                }
                return ret;
            }
            else if(list.get(m).compareTo(x) < 0)
            {
                l = m+1;
            }
            else
            {
                r = m-1;
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */