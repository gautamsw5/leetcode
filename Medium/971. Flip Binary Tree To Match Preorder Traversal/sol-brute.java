class FlipToMatch
{
    TreeNode fp; int i; boolean brk;
    void preord(TreeNode root, int[] arr, TreeNode par)
    {
        if(root!=null && brk)
        {
            if(root.val!=arr[i]) { fp = par; brk = false; return; }
            i++;
            preord(root.left, arr, root);
            preord(root.right, arr, root);
        }
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] arr)
    {
        List<Integer> err = new ArrayList<>(); err.add(-1);
        if(root.val!=arr[0]) return err; fp = root;
        List<Integer> flip = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        while(fp!=null)
        {
            i=0; fp = null; brk = true;
            preord(root, arr, null);
            if(fp!=null)
            {
                if(set.contains(fp)) return err;
                TreeNode t = fp.left;  fp.left = fp.right; fp.right = t;
                set.add(fp);
                flip.add(fp.val);
            }
        }
        return flip;
    }
}