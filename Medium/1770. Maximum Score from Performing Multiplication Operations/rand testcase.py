import random
file = open('tmp.txt','w')
for t in range(40):
    m=random.randint(1,1000)
    mul=[]
    n=random.randint(m,m+100)
    arr=[]
    for i in range(n):
        arr.append(random.randint(-1000,1000))
    for i in range(m):
        mul.append(random.randint(-1000,1000))
    file.write(str(arr)+'\n'+str(mul)+'\n')
file.close()
