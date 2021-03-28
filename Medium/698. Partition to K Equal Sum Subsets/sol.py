class Solution:
    def canPartitionKSubsets(self, arr, k: int) -> bool:
        s = sum(arr)
        if s%k!=0:
            return False
        t = s//k
        def solve(arr,k):
            if k==0:
                return True
            for x in range(1,1<<len(arr)):
                drr = []
                sm = 0
                for z in range(len(arr)):
                    if x%2==1:
                        sm += arr[z]
                        drr = [z] + drr
                    x = x//2
                if sm==t:
                    brr = list(arr)
                    for z in drr:
                        del brr[z]
                    if solve(brr,k-1):
                        return True
            return False
        return solve(arr,k)
ob = Solution()
t = int(input())
for zzz in range(t):
    ar = list(map(int,input().strip().split()))
    k = int(input())
    print(ob.canPartitionKSubsets(ar,k))
