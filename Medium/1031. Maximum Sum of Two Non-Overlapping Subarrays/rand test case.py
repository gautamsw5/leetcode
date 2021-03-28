import random
file = open('tmp.txt','w')
for t in range(50):
    n=random.randint(2,1000)
    arr=[]
    for i in range(n):
        arr.append(random.randint(0,1000))
    L=str(random.randint(1,n))
    M=str(random.randint(1,n-int(L)))
    file.write(str(arr).replace(" ","")+'\n'+L+'\n'+M+'\n')
file.close()
