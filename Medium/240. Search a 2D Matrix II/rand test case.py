import random
file = open('tmp.txt','w')
Y = 10**9
for t in range(10):
    n=random.randint(1,300)
    m=random.randint(1,300)
    x=random.randint(-Y,Y)
    arr=[]
    for i in range(n):
        t=[]
        for j in range(m):
            if len(arr)>0:
                t.append(random.randint(arr[-1][j],Y))
            else:
                t.append(random.randint(-Y,Y))
        t.sort()
        arr.append(t)
    arr.sort()
    file.write(str(arr).replace(" ","")+'\n'+str(x)+'\n')
file.close()
