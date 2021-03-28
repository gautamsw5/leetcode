public class Node
{
    int x;
    List<Node> adj;
    public Node(int y)
    {
        x = y;
        adj = new ArrayList<>();
    }
}
class Solution
{
    private boolean onedif(String s1, String s2)
    {
        int i = 0,
        j = 0;
        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
                if(i-j>1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int longestStrChain(String[] Words)
    {
        List<List<String>> arr = new ArrayList<>();
        List<List<Integer>> irr = new ArrayList<>();
        List<String> words = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s:Words)
        {
            if(!set.contains(s))
            {
                set.add(s);
                words.add(s);
            }
        }
        Node[] graph = new Node[words.size()];
        for(int i=0; i<17; i++)
        {
            arr.add(new ArrayList<>());
            irr.add(new ArrayList<>());
        }
        int i=0;
        for(String s:words)
        {
            arr.get(s.length()).add(s);
            irr.get(s.length()).add(i);
            graph[i] = new Node(i);
            i++;
        }
        int ans = 1;
        for(i=1; i<16; i++)
        {
            int j = 0;
            for(String s:arr.get(i))
            {
                int k = 0;
                for(String t:arr.get(i+1))
                {
                    if(onedif(t,s))
                    {
                        graph[irr.get(i).get(j)].adj.add(graph[irr.get(i+1).get(k)]);
                    }
                    k++;
                }
                j++;
            }
        }
        for(i=1; i<16; i++)
        {
            for(int j : irr.get(i))
            {
                // bfs on graph[j]
                Queue<Node> que = new LinkedList<>();
                Queue<Node> nxt = new LinkedList<>();
                que.add(graph[j]);
                int d=0;
                while(que.size()>0)
                {
                    while(que.size()>0)
                    {
                        Node cur = que.remove();
                        for(Node v:cur.adj)
                        {
                            nxt.add(v);
                        }
                    }
                    d++;
                    que = nxt;
                    nxt = new LinkedList<>();
                }
                ans = Math.max(ans,d);
            }
        }
        return ans;
    }
}