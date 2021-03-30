# https://leetcode.com/problems/break-a-palindrome/discuss/1131528/Python3-O(n2)-and-O(n)-solutions
class Solution:
    def breakPalindrome(self, s: str) -> str:
        if len(s)<=1:
            return ""
        if s[0]!="a":
            return "a"+s[1:]
        i = 0
        while i<len(s) and s[i]=="a":
            i += 1
        if len(s)%2==1 and i==len(s)//2:
            i += 1
            while i<len(s) and s[i]=="a":
                i += 1
        if i==len(s):
            return s[:-1]+"b"
        return s[:i]+"a"+s[i+1:]
ob = Solution()
t = int(input())
for i in range(t):
    s=input("Enter a palindrome: ")
    print(ob.breakPalindrome(s))
