class Solution:
    def checkIfCanBreak(self, s1: str, s2: str) -> bool:
        s1=list(s1)
        s2=list(s2)
        s1.sort()
        s2.sort()
        n = len(s1)
        f = True
        for i in range(0,n):
            if s2[n-i-1] > s1[i]:
                f = False
                break
        if f:
            return f
        f = True
        for i in range(0,n):
            if s1[n-i-1] > s2[i]:
                f = False
                break
        if f:
            return f
        f = True
        for i in range(0,n):
            if s1[i] > s2[i]:
                f = False
                break
        if f:
            return f
        f = True
        for i in range(0,n):
            if s1[i] < s2[i]:
                f = False
                break
        return f
