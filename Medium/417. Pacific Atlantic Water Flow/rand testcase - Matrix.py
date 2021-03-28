import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(50):
    n=random.randint(1,150)
    m=random.randint(1,150)
    arr = []
    for i in range(n):
        arr.append([])
        for j in range(m):
            arr[i].append(random.randint(-2**31,2**31-1))
    file.write(str(arr).replace(" ","")+'\n')
file.close()
