import random
file = open('tmp.txt','w')
Y = 10**5
for t in range(10**5):
    a=random.randint(1,Y)
    b=random.randint(1,Y)
    c=random.randint(1,Y)
    file.write(str(a)+'\n'+str(b)+'\n'+str(c)+'\n')
file.close()
