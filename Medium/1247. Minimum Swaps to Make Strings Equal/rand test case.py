import random
file = open('tmp.txt','w')
for t in range(500):
    n1 = random.randint(1,1000)
    s=""
    t=""
    for i in range(n1):
        s=s+chr(ord('x')+random.randint(0,1))
    for i in range(n1):
        t=t+chr(ord('x')+random.randint(0,1))
    file.write("\""+s+'\"\n')
    file.write("\""+t+'\"\n')
file.close()
