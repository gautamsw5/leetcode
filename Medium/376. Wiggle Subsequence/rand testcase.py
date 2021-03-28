import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(1000):
    n=random.randint(1,1000)
    arr=[]
    for i in range(n):
        arr.append(random.randint(0,1000))
    file.write(str(arr)+'\n')
file.close()
