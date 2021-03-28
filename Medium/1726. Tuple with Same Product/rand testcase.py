import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(50):
    n=random.randint(1,1000)
    arr=[]
    for i in range(n):
        x = random.randint(1,10000)
        while x in arr:
            x = random.randint(1,10000)
        arr.append(x)
    file.write(str(arr)+'\n')
file.close()
