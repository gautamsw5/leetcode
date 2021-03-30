import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
l=1
r=10**4
N=5000
for t in range(10):
    n=random.randint(1,N)
    m=2
    arr = []
    for i in range(n):
        arr.append([])
        for j in range(m):
            arr[i].append(random.randint(l,r))
    file.write(str(arr).replace(" ","")+'\n')
file.close()
