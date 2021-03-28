import heapq
class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        ans =[]
        s=""
        for i in searchWord:
            s = s+i
            t=[]
            pq = []
            # heapq.heapify(pq)
            a=""
            b=""
            c=""
            for x in products:
                if x.startswith(s):
                    #heapq.heappush(pq,x)
                    pq.append(x)
                    if len(a)==0:
                        a=x
                    elif  x<a:
                        c=b
                        b=a
                        a=x
                    elif len(b)==0 or x<b:
                        c=b
                        b=x
                    elif len(c)==0 or x<c:
                        c=x
            products = list(pq)
            if len(a)>0:
                t.append(a)
            if len(b)>0:
                t.append(b)
            if len(c)>0:
                t.append(c)
            # while len(pq)>0 and len(t)<3:
            #     t.append(heapq.heappop(pq))
            ans.append(t)
        return ans
