# https://leetcode.com/problems/finding-mk-average/discuss/1153727/Python3-SortedList
"""
Create a SortedList srr and an array arr.
arr contains all elements in the order they are inserted.
srr contains last m elements of arr in sorted order.
midsum is the sum of elements of srr excluding 1st k and last k elements.
While taking average size would be n = m - 2 * k
whenever a new element has to be inserted, remove (arr.length-m)th element from srr,
do this operation while keeping track of midsum so that complexity for addElement() is log(n).
inserpos() used to determine at what position will a new elemet get inserted when added to srr.
"""
from sortedcontainers import SortedList
class MKAverage:
    def __init__(self, m: int, k: int):
        self.m = m
        self.k = k
        self.arr = []
        self.srr = SortedList([])
        self.midsum = 0
        self.n = self.m - 2*self.k
    def insertpos(self, x: int) -> int:
        l = 0
        r = self.m-1
        if x<=self.srr[0]:
            return 0
        if x>=self.srr[-1]:
            return self.m
        while l<=r:
            m = (l+r)//2
            if self.srr[m]<x and (m+1==len(self.srr) or self.srr[m+1]>=x):
                return m+1
            elif self.srr[m]<x:
                l = m + 1
            else:
                r = m - 1
        return -1
    def addElement(self, x: int) -> None:
        self.arr.append(x)
        if len(self.arr)==self.m:
            arr = sorted(self.arr)
            for i in range(self.k):
                self.srr.add(arr[i])
            for i in range(self.k, self.m-self.k):
                self.srr.add(arr[i])
                self.midsum += arr[i]
            for i in range(self.m-self.k, self.m):
                self.srr.add(arr[i])
        if len(self.arr)<=self.m:
            return
        rem = self.arr[-self.m-1]
        if rem<=self.srr[self.k-1]:
            self.srr.remove(rem)
            ip = self.insertpos(x)
            if ip>=self.k and ip<=self.m-self.k-1:
                self.midsum += x - self.srr[self.k-1]
            elif ip>self.m-self.k-1:
                self.midsum += self.srr[self.m-self.k-1] - self.srr[self.k-1]
            self.srr.add(x)
        elif rem<=self.srr[self.m-self.k-1]:
            self.srr.remove(rem)
            ip = self.insertpos(x)
            self.midsum -= rem
            if ip<self.k:
                self.midsum += self.srr[self.k-1]
            elif ip>=self.k and ip<=self.m-self.k-1:
                self.midsum += x
            else:
                self.midsum += self.srr[self.m-self.k-1]
            self.srr.add(x)
        else:
            self.srr.remove(rem)
            ip = self.insertpos(x)
            if ip<self.k:
                self.midsum += self.srr[self.k-1] - self.srr[self.m-self.k-1]
            elif ip>=self.k and ip<=self.m-self.k-1:
                self.midsum += x - self.srr[self.m-self.k-1]
            self.srr.add(x)
    def calculateMKAverage(self) -> int:
        if len(self.arr)<self.m:
            return -1
        else:
            return self.midsum//self.n
m,k = list(map(int,input("Enter m and k space separated: ").strip().split()))
ob = MKAverage(m,k)
while True:
    print("1. add element")
    print("2. calculate average of last m excluding k min and k max")
    print("3. Print all elements entered until now")
    print("4. Pring last m elements in sorted order")
    n = int(input("Enter your choice: "))
    if n==1:
        ob.addElement(int(input("Enter element to add: ")))
    elif n==2:
        print("Average is:",ob.calculateMKAverage())
    elif n==3:
        print(ob.arr)
    elif n==4:
        print(ob.srr)
    print()
