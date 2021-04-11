class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vow = set(['a','e','i','o','u','A','E','I','O','U']) # Set of all vowels
        c = 0
        for i in range(0,len(s)//2):
            if s[i] in vow:
                c += 1                 # Count vowels in first half
        for i in range(len(s)//2, len(s)):
            if s[i] in vow:
                c -= 1                 # Subtract count of second half from first half
        return c==0                    # Result must be 0 for them to have equal vowels on both parts
ob = Solution()
t = int(input())
for i in range(t):
    print(ob.halvesAreAlike(input()))
