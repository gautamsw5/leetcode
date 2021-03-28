class Solution:
    def maxSatisfaction(self, arr: List[int]) -> int:
        arr.sort(reverse=True)
        #ans = 0
        cur = 0
        s = 0
        c = 0
        for i in range(len(arr)):
            if cur+s+arr[i] > cur:
                cur = cur+s+arr[i]
                c = c+1
                s = s+arr[i]
        return cur
