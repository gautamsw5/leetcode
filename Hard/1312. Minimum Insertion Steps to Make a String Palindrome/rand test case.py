import random
file = open('tmp.txt','w')
for t in range(500):
    n1 = random.randint(1,500)
    s=""
    for i in range(n1):
        s=s+chr(ord('a')+random.randint(0,25))
    file.write("\""+s+'\"\n')
file.close()
