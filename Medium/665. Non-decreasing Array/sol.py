class Solution:
    def checkPossibility(self, arr) -> bool:
        def stred(xrr):
            for i in range(len(xrr)-1):
                if xrr[i] > xrr[i+1]:
                    return False
            return True
        for i in range(len(arr)-1):
            if arr[i] > arr[i+1]:
                brr = list(arr)
                del brr[i]
                if stred(brr):
                    return True
                brr = list(arr)
                del brr[i+1]
                if stred(brr):
                    return True
                return False
        return True