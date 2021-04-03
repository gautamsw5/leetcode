class Solution:
    def movesToStamp(self, stamp: str, target: str):
        def equal(a,b): # b-> can have '?'
            c=0
            for i in range(len(a)):
                if a[i]!=b[i] and b[i]!='?':
                    return False
                if b[i]=='?':
                    c += 1
            return c<len(b)   # if b has only ?'s, return false, 
             # because there is no need to replace it will just increase
                          # the output array length and runtime.
        ans = []
        n = len(target)
        tar = '?'*n
        m = len(stamp)
        f = True
        while len(ans)<10*n and f and target!=tar:
            start = 0
            f=False
            while start+m<=n:
                if equal(stamp, target[start:start+m]):
                    ans.append(start)
                    target = target[:start] + '?'*m + target[start+m:]
                    f=True
                start+=1
        if target == tar:
            return ans[::-1]
        return []
ob = Solution()
while True:
    print(ob.movesToStamp(input("Stamp: "),input("Target: ")))
