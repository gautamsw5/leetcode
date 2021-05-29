/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{

    public:
    int ans;
    void solve(TreeNode* root, int s, int d)
    {
        if(root == NULL)
            return;
        if(s==0)
        {
            solve(root->right, 0, 1);
            solve(root->left, 1, d+1);
        }
        else
        {
            solve(root->left, 1, 1);
            solve(root->right, 0, d+1);
        }
        if(ans < d)
            ans = d;
    }
    int longestZigZag(TreeNode* root)
    {
        ans = 0;
        solve(root->left, 1, 1);
        solve(root->right, 0, 1);
        return ans;
    }
};