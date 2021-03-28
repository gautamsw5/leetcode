import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(500):
    n=random.randint(1,500)
    arr=[]
    for i in range(n):
        arr.append(random.randint(-1000,1000))
        arr.sort()
    file.write(str(arr)+'\n')
file.close()
