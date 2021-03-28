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
    private Map<TreeNode, Integer> subsum;
    private Map<Integer, Integer> freq;
    private int getsub(TreeNode root)
    {
        int sum = 0;
        if(root!=null)
        {
            sum += root.val;
            sum += getsub(root.left);
            sum += getsub(root.right);
            subsum.put(root, sum);
            freq.put(sum, freq.getOrDefault(sum,0)+1);
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root)
    {
        subsum = new HashMap<>();
        freq = new HashMap<>();
        getsub(root);
        //System.out.println(subsum);
        int m = 0;
        List<Integer> ans = new ArrayList<>();
        for(int s:freq.keySet())
        {
            if(m<freq.get(s))
            {
                ans = new ArrayList<>();
                ans.add(s);
                m=freq.get(s);
            }
            else if(m==freq.get(s))
            {
                ans.add(s);
            }
        }
        int[] ret = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            ret[i] = ans.get(i);
        }
        return ret;
    }
}