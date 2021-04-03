import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
l=-10**4
r=10**4
for t in range(100):
    n=random.randint(1,2500)
    arr = []
    for i in range(n):
        arr.append(random.randint(l,r))
    file.write(str(arr).replace(" ","")+'\n')
file.close()
