class Solution
{
    List<List<Integer>> ret;
    List<Integer> t;
    int[][] dp;
    public void dfs(int[][] grid, int x, int y, int o)
    {
        if(x>grid.length-1 || x<0 || y<0 || y>grid[x].length)
        {
            return;
        }
        if(dp[x][y]!=3 && dp[x][y]!=-1)
        {
            if(dp[x][y]==0)
            {
                dp[x][y] = o;
            }
            else if(dp[x][y]==o)
            {
                return;
            }
            else if((dp[x][y]==1 && o==2) || (dp[x][y]==2 && o==1))
            {
                dp[x][y] = 3;
                t=new ArrayList<>();
                t.add(x);
                t.add(y);
                ret.add(t);
            }
            if(x>0 && grid[x-1][y]>=grid[x][y])
            dfs(grid,x-1,y,o);
            if(x+1<grid.length && grid[x+1][y]>=grid[x][y])
            dfs(grid,x+1,y,o);
            if(y>0 && grid[x][y-1]>=grid[x][y])
            dfs(grid,x,y-1,o);
            if(y+1<grid[x].length && grid[x][y+1]>=grid[x][y])
            dfs(grid,x,y+1,o);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix)
    {
        ret = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0)
        {
            return ret;
        }
        dp = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length;i++)
        {
            dfs(matrix,i,0,1);
            //System.out.println(i+" "+0);
            dfs(matrix,i,matrix[i].length-1,2);
            //System.out.println(i+" "+(matrix[i].length-1));
        }
        for(int i=0; i<matrix[0].length;i++)
        {
            dfs(matrix,0,i,1);
            //System.out.println(0+" "+i);
            dfs(matrix,matrix.length-1,i,2);
            //System.out.println((matrix.length-1)+" "+i);
        }
        return ret;
    }
}