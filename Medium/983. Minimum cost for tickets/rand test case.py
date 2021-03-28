import random
file = open('tmp.txt','w')
for t in range(500):
    i=1
    n=random.randint(1,365)
    arr=[]
    while i<366 and len(arr)<n:
        if random.randint(0,1)==0:
            arr.append(i)
        i+=1
    cost=[random.randint(1,1000),random.randint(1,1000),random.randint(1,1000)]
    file.write(str(arr)+'\n')
    file.write(str(cost)+'\n')
file.close()
