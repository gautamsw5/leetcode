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
    public boolean isEvenOddTree(TreeNode root)
    {
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> nxt = new LinkedList<>();
        que.add(root);
        while(que.size()>0)
        {
            int prev = 0;
            while(que.size()>0)
            {
                TreeNode cur = que.remove();
                if(cur.val%2==0 || cur.val<=prev)
                {
                    return false;
                }
                if(cur.left!=null)
                {
                    nxt.add(cur.left);
                }
                if(cur.right!=null)
                {
                    nxt.add(cur.right);
                }
                prev = cur.val;
            }
            que = nxt;
            nxt = new LinkedList<>();
            prev = 1000001;
            while(que.size()>0)
            {
                TreeNode cur = que.remove();
                if(cur.val%2==1 || cur.val>=prev)
                {
                    return false;
                }
                if(cur.left!=null)
                {
                    nxt.add(cur.left);
                }
                if(cur.right!=null)
                {
                    nxt.add(cur.right);
                }
                prev = cur.val;
            }
            que = nxt;
            nxt = new LinkedList<>();
        }
        return true;
    }
}