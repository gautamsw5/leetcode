class TreeNode
{
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int v)
    {
        val = v;
    }
}
class Solution
{
    int ans;
    void solve(TreeNode root, int s, int d)
    {
        if(root == null)
            return;
        if(s==0)
        {
            solve(root.right, 0, 1);
            solve(root.left, 1, d+1);
        }
        else
        {
            solve(root.left, 1, 1);
            solve(root.right, 0, d+1);
        }
        if(ans < d)
            ans = d;
    }
    public int longestZigZag(TreeNode root)
    {
        ans = 0;
        solve(root.left, 1, 1);
        solve(root.right, 0, 1);
        return ans;
    }
}