class Solution:
    def replaceWords(self, dct: List[str], s: str) -> str:
        arr = s.split()
        dct.sort()
        for i in range(0,len(arr)):
            for j in dct:
                if arr[i].startswith(j):
                    arr[i]=j
                    break
        s=""
        for i in arr:
            s=s+i+" "
        return s[:-1]
