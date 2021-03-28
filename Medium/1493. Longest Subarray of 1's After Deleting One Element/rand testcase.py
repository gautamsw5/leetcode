import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(13):
    arr = []
    n=random.randint(1,10)
    for i in range(n):
        x = random.randint(1,10)
        if x<3:
            arr.append(0)
        else:
            arr.append(1)
    file.write(str(arr).replace(" ","")+'\n')
for t in range(12):
    arr = []
    n=random.randint(1,100)
    for i in range(n):
        x = random.randint(1,10)
        if x<3:
            arr.append(0)
        else:
            arr.append(1)
    file.write(str(arr).replace(" ","")+'\n')
for t in range(10):
    arr = []
    n=random.randint(1,1000)
    for i in range(n):
        x = random.randint(1,10)
        if x<3:
            arr.append(0)
        else:
            arr.append(1)
    file.write(str(arr).replace(" ","")+'\n')
for t in range(3):
    arr = []
    n=random.randint(1,100000)
    for i in range(n):
        x = random.randint(1,10)
        if x<3:
            arr.append(0)
        else:
            arr.append(1)
    file.write(str(arr).replace(" ","")+'\n')
file.close()
