/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    public List<Integer> largestValues(TreeNode root)
    {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> nxt = new LinkedList<>();
        if(root!=null)
        que.add(root);
        while(que.size()>0)
        {
            int max = Integer.MIN_VALUE;
            while(que.size()>0)
            {
                TreeNode cur = que.remove();
                max = Math.max(cur.val,max);
                if(cur.left!=null)
                {
                    nxt.add(cur.left);
                }
                if(cur.right!=null)
                {
                    nxt.add(cur.right);
                }
            }
            ret.add(max);
            que = nxt;
            nxt = new LinkedList<>();
        }
        return ret;
    }
}