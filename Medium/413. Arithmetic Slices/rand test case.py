import random
file = open('tmp.txt','w')
for t in range(10):
    n=random.randint(1,50000)
    arr=[]
    for i in range(n):
        arr.append(random.randint(-100,100))
    file.write(str(arr).replace(" ","")+'\n')
for t in range(5):
    n=random.randint(1,50000)
    arr=[]
    for i in range(n):
        arr.append(random.randint(-10**9,10**9))
    file.write(str(arr).replace(" ","")+'\n')
file.close()
