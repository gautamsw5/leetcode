class Solution:
    def wiggleMaxLength(self, arr) -> int:
        ret = 0
        # Positive diff first, take start term as -1     + - + - ... 
        i = 1
        p = arr[0]
        ans=[p]
        while i<len(arr):
            while i<len(arr) and arr[i]>=arr[i-1]:
                i += 1
            if i<len(arr):
                ans.append(arr[i])
                i += 1
            while i<len(arr) and arr[i]<=arr[i-1]:
                i += 1
            if i<len(arr):
                ans.append(arr[i])
                i += 1
        ret = len(ans)
        # Negative diff
        i = 1
        p = arr[0]
        ans=[p]
        while i<len(arr):
            while i<len(arr) and arr[i]<=arr[i-1]:
                i += 1
            if i<len(arr):
                ans.append(arr[i])
                i += 1
            while i<len(arr) and arr[i]>=arr[i-1]:
                i += 1
            if i<len(arr):
                ans.append(arr[i])
                i += 1
        ret = max(ret,len(ans))
        return ret
