class Solution:
    def romanToInt(self, s: str) -> int:
        i = 0
        ans = 0
        while i<len(s):
            if s[i]=='I':
                if i+1<len(s) and s[i+1]=='V':
                    i += 2
                    ans += 4
                elif i+1<len(s) and s[i+1]=='X':
                    i += 2
                    ans += 9
                else:
                    i += 1
                    ans += 1
            elif s[i]=='X':
                if i+1<len(s) and s[i+1]=='L':
                    i += 2
                    ans += 40
                elif i+1<len(s) and s[i+1]=='C':
                    i += 2
                    ans += 90
                else:
                    i += 1
                    ans += 10
            elif s[i]=='C':
                if i+1<len(s) and s[i+1]=='D':
                    i += 2
                    ans += 400
                elif i+1<len(s) and s[i+1]=='M':
                    i += 2
                    ans += 900
                else:
                    i += 1
                    ans += 100
            elif s[i]=='V':
                ans += 5
                i += 1
            elif s[i]=='L':
                ans += 50
                i += 1
            elif s[i]=='D':
                ans += 500
                i += 1
            elif s[i]=='M':
                ans += 1000
                i += 1
        return ans
