import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(5):
    n=random.randint(1,40000)
    arr=[]
    for i in range(n):
        arr.append(random.randint(1,10**4))
    file.write(str(arr)+'\n')
file.close()
