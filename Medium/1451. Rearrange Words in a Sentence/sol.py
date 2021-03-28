import heapq
class Solution:
    def arrangeWords(self, text: str) -> str:
        pq=[]
        heapq.heapify(pq)
        n=0
        arr = text.lower().split()
        for i in arr:
            heapq.heappush(pq,[len(i),n])
            n=n+1
        w = arr[heapq.heappop(pq)[1]]
        ret = w[0].upper()+w[1:]
        while(len(pq)>0):
            w = arr[heapq.heappop(pq)[1]]
            ret += " " + w
        return ret
