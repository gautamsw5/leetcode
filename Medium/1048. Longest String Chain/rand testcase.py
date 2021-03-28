import random
file = open('tmp.txt','w')
for t in range(50):
    n=random.randint(1,1000)
    arr=[]
    for i in range(n):
        s=""
        x=random.randint(1,16)
        for j in range(x):
            s=s+chr(random.randint(97,122))
        arr.append(s)
        #arr.append('a'*x)
    file.write(str(arr).replace("'",'"')+'\n')
file.close()
