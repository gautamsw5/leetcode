public class Node
{
    int i;
    List<Node> adj;
    List<Integer> cost;
    int dist;
    Node(int x)
    {
        i = x;
        adj = new ArrayList<>();
        cost = new ArrayList<>();
        dist = Integer.MAX_VALUE;
    }
}
class Solution
{
    public int mincostTickets(int[] days, int[] costs)
    {
        Node[] graph = new Node[days.length+1];
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new Node(i<days.length?days[i]:-1);
        }
        graph[0].dist=0;
        for(int i=0;i<graph.length-1;i++)
        {
            graph[i].adj.add(graph[i+1]);
            graph[i].cost.add(Math.min(costs[0],Math.min(costs[1],costs[2])));
            for(int j=i+2; j<graph.length; j++)
            {
                if(days[j-1]-days[i]<7)
                {
                    graph[i].adj.add(graph[j]);
                    graph[i].cost.add(Math.min(costs[1],costs[2]));
                }
                else if(days[j-1]-days[i]<30)
                {
                    graph[i].adj.add(graph[j]);
                    graph[i].cost.add(costs[2]);
                }
                else
                {
                    break;
                }
            }
        }
        for(int i = 0; i<graph.length; i++)
        {
            for(int j=0; j<graph[i].adj.size(); j++)
            {
                graph[i].adj.get(j).dist = Math.min(graph[i].adj.get(j).dist ,
                                               graph[i].dist + graph[i].cost.get(j));
            }
        }
        return graph[days.length].dist;
    }
}