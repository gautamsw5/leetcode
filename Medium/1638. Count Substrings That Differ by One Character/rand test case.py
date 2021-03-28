import random
file = open('tmp.txt','w')
for t in range(50):
    n1 = random.randint(1,100)
    n2 = random.randint(1,100)
    s=""
    t=""
    for i in range(n1):
        s=s+chr(ord('a')+random.randint(0,25))
    for i in range(n2):
        t=t+chr(ord('a')+random.randint(0,25))
    file.write("\""+s+'\"\n')
    file.write("\""+t+'\"\n')
file.close()
