class TreeNode:
    def __init__(self, v = 0) -> None:
        self.val = v
        self.left = None
        self.right = None
class Solution:
    def solve(self, root, s, d):
        if root == None:
            return
        if s==0:
            self.solve(root.right, 0, 1)
            self.solve(root.left, 1, d+1)
        else:
            self.solve(root.left, 1, 1)
            self.solve(root.right, 0, d+1)
        self.ans = max(self.ans, d)
    def longestZigZag(self, root: TreeNode) -> int:
        self.ans = 0
        self.solve(root.left, 1, 1)
        self.solve(root.right, 0, 1)
        return self.ans