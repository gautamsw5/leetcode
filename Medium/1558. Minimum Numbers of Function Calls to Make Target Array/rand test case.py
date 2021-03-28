import random
file = open('tmp.txt','w')
for t in range(500):
    n=random.randint(1,150)
    arr=[]
    for i in range(n):
        arr.append(random.randint(0,10**9))
    file.write(str(arr).replace(" ","")+'\n')
file.close()
