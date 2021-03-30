# https://leetcode.com/problems/break-a-palindrome/discuss/1131528/Python3-O(n2)-and-O(n)-solutions
class Solution:
    def breakPalindrome(self, s: str) -> str:
        if len(s)<=1:
            return ""
        def pali(sr):
            return sr==sr[::-1]
        ans = "z"*len(s)
        for c in range(97,123):
            for i in range(len(s)):
                x = s[:i]+ chr(c) + s[i+1:]
                if not pali(x) and ans>x:
                    ans = x
        return ans
ob = Solution()
t = int(input())
for i in range(t):
    s=input("Enter a palindrome: ")
    print(ob.breakPalindrome(s))
