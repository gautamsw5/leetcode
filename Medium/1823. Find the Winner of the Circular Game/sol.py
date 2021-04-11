# https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1153739/Python3-Stimulation-Easy
class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        arr = [i+1 for i in range(n)]
        prev = k-1     # k-1 steps from 1
        for i in range(n-1):
            del arr[prev] # delete 
            #print(arr)
            prev = (prev+k-1)%len(arr) # move k-1 more steps, mod because circular
        return arr[0]
ob = Solution()
n,k = list(map(int,input("Enter n and k space separated: ").strip().split()))
print(ob.findTheWinner(n,k))
