import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(1000):
    n=random.randint(1,20)
    k=random.randint(1,2**n-1)
    file.write(str(n)+'\n'+str(k)+'\n')
file.close()
