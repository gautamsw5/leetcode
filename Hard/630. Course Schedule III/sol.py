import heapq
class Solution:
    def scheduleCourse(self, arr) -> int:
        arr.sort(key = lambda x : (x[1], x[0]))
        pq = []
        heapq.heapify(pq)
        #print(arr)
        n = 0
        i = 0
        t = 0
        while i<len(arr):
            if t+arr[i][0] <= arr[i][1]:
                heapq.heappush(pq, [-arr[i][0], arr[i][1]])
                t += arr[i][0]
                n += 1
                #print("Add:",arr[i],"t:",t)
            elif len(pq)>0:
                x = pq[0]
                #print("Cur:",arr[i],"Rem cand:",[-x[0],x[1]])
                if t + x[0] + arr[i][0] <= arr[i][1] and -x[0]>arr[i][0]:
                    heapq.heappop(pq)
                    #print("Remove:",[-x[0],x[1]],"t:",(t+x[0]))
                    t = t + x[0] + arr[i][0]
                    heapq.heappush(pq, [-arr[i][0], arr[i][1]])
                    #print("Add:",arr[i],"t:",t)
            # else:
            #     skip = -1
            #     for j in range(len(pq)):
            #         if t - pq[j][0] + arr[i][0] <= arr[i][1] and pq[j][0]>arr[i][0] and (skip==-1 or pq[j][0]>pq[skip][0]):
            #             skip = j
            #     if skip > -1:
            #         t = t - pq[skip][0] + arr[i][0]
            #         del pq[skip]
            #         pq.append(arr[i])
            i += 1
        return n