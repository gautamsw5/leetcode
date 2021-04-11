import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(50):
    n=random.randint(1,200)
    m=random.randint(1,200)
    arr = []
    for i in range(n):
        arr.append([])
        for j in range(m):
            arr[i].append(random.randint(0,2**31-1))
    file.write(str(arr).replace(" ","")+'\n')
file.close()
