class Solution
{
    private boolean[] visited;
    private List<List<Integer>> graph;
    private void dfs(int v)
    {
        if(!visited[v])
        {
            visited[v] = true;
            for(int u : graph.get(v))
            {
                if(!visited[u] && u!=v)
                {
                    //System.out.println(u+" "+visited[u]);
                    dfs(u);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        visited = new boolean[rooms.size()];
        graph = rooms;
        dfs(0);
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }
        return true;
    }
}