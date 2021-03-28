import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(500):
    n=random.randint(2,16)
    k=random.randint(2,n)
    arr = []
    for i in range(n):
        arr.append(random.randint(1,999))
    file.write(str(arr).replace(" ","")+'\n'+str(k)+'\n')
file.close()
