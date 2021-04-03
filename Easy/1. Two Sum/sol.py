class Solution:
    def twoSum(self, arr, t):
        for i in range(len(arr)):
            arr[i] = [arr[i],i]
        arr.sort()
        l=0
        r=len(arr)-1
        while l<r:
            if arr[l][0]+arr[r][0]==t:
                return [arr[l][1],arr[r][1]]
            elif arr[l][0]+arr[r][0]>t:
                r -= 1
            else:
                l += 1
        return []
