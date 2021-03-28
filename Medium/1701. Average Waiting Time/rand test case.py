import random
file = open('tmp.txt','w')
for t in range(12):
    n=random.randint(1,10)
    arr=[]
    arr.append([random.randint(1,10),random.randint(1,10**4)])
    for i in range(1,n):
        arr.append([random.randint(arr[i-1][0],10),random.randint(1,10**4)])
    file.write(str(arr).replace(" ","")+'\n')
for t in range(12):
    n=random.randint(1,10)
    arr=[]
    arr.append([random.randint(1,10**4),random.randint(1,10**4)])
    for i in range(1,n):
        arr.append([random.randint(arr[i-1][0],10**4),random.randint(1,10**4)])
    file.write(str(arr).replace(" ","")+'\n')
for t in range(10):
    n=random.randint(1,100)
    arr=[]
    arr.append([random.randint(1,10**4),random.randint(1,10**4)])
    for i in range(1,n):
        arr.append([random.randint(arr[i-1][0],10**4),random.randint(1,10**4)])
    file.write(str(arr).replace(" ","")+'\n')
for t in range(7):
    n=random.randint(1,1000)
    arr=[]
    arr.append([random.randint(1,10**4),random.randint(1,10**4)])
    for i in range(1,n):
        arr.append([random.randint(arr[i-1][0],10**4),random.randint(1,10**4)])
    file.write(str(arr).replace(" ","")+'\n')
for t in range(3):
    n=random.randint(1,10000)
    arr=[]
    arr.append([random.randint(1,10**4),random.randint(1,10**4)])
    for i in range(1,n):
        arr.append([random.randint(arr[i-1][0],10**4),random.randint(1,10**4)])
    file.write(str(arr).replace(" ","")+'\n')
for t in range(3):
    n=random.randint(1,100000)
    arr=[]
    arr.append([random.randint(1,10**4),random.randint(1,10**4)])
    for i in range(1,n):
        arr.append([random.randint(arr[i-1][0],10**4),random.randint(1,10**4)])
    file.write(str(arr).replace(" ","")+'\n')
file.close()
