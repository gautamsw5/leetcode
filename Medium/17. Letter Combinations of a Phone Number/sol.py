class Solution:
    def letterCombinations(self, digits: str):
        if len(digits)==0:
            return []
        dct = {2:"abc", 3:"def", 4:"ghi", 5:"jkl", 6:"mno", 7:"pqrs", 8:"tuv", 9:"wxyz"}
        self.digits = [list(dct[int(i)]) for i in digits]
        self.ans = []
        def solve(idx, cur):
            if idx==len(self.digits):      # When one letter from every digit has been picked
                self.ans.append(str(cur))  # Add to solution
                return                     # Pop from recursion stack
            for i in self.digits[idx]:     # Current index of result has all choices corresponding to the digit at current index (idx)
                solve(idx+1, cur+i)        # Solve for next index using recursion
        solve(0, "")
        return self.ans
ob = Solution()
t = int(input())
for i in range(t):
    print(ob.letterCombinations(input()))
