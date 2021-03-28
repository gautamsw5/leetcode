class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        dct = {}
        for i in range(len(s)):
            if s[i]=="(":
                j = i
                x = 0
                while True:
                    if s[j]=="(":
                        x = x + 1
                    else:
                        x = x - 1
                        if x==0:
                            dct[i]=j
                            break
                    j = j + 1
        #print(dct)
        def solve(l,r):
            if r==l+1:
                return 1
            if dct[l]==r:
                return 2*solve(l+1,r-1)
            ans = 0
            while l<r:
                ans += solve(l,dct[l])
                l = dct[l]+1
            return ans
        return solve(0,len(s)-1)
