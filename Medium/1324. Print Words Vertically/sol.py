class Solution:
    def printVertically(self, s: str) -> List[str]:
        brr = s.split()
        ans = []
        f = True
        idx = 0
        while f:
            f=False
            s = ""
            for i in range(len(brr)):
                if idx>=len(brr[i]):
                    s += " "
                else:
                    s += brr[i][idx]
                    f = True
            idx += 1
            if len(s.strip())!=0:
                ans.append(s.rstrip())
        return ans
