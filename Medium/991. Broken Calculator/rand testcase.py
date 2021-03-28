import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(1000):
    n=random.randint(1,10**9)
    file.write(str(n)+'\n')
file.close()
