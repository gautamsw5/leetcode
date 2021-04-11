# https://leetcode.com/problems/find-median-from-data-stream/discuss/1153683/Python3-SortedList-solution
from sortedcontainers import SortedList
class MedianFinder:
    def __init__(self):
        self.srr = SortedList()  # SortedList has insert O(log(n)) can hold duplicates and remains sorted upon insertion.
        self.n = 0
    def addNum(self, x: int) -> None:
        self.srr.add(x)
        self.n += 1
    def findMedian(self) -> float:
        if self.n%2==1:
            return self.srr[self.n//2]  # Access element O(1)
        else:
            return (self.srr[self.n//2]+self.srr[self.n//2-1])/2
ob = MedianFinder()
while True:
    ob.addNum(int(input("Enter element to add: ")))
    print("Median:",ob.findMedian())
