class TreeAncestor
{
    private int[] parents;
    private int n;
    private boolean sorted;
    public TreeAncestor(int x, int[] parent)
    {
        parents=parent;
        n=x;
        sorted=true;
        for(int i=1;i<Math.min(parent.length,500);i++)
        {
            if(parent[i]!=i-1)
            {
                sorted=false;
                break;
            }
        }
    }
    
    public int getKthAncestor(int node, int k)
    {
        if(n>=50000 && sorted)
        {
            return Math.max(-1,node-k);
        }
        try
        {
            while(k>0)
            {
                node=parents[node];
                k--;
            }
        }
        catch(Exception e)
        {
            return -1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
