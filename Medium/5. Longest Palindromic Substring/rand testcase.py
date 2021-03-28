import random
file = open('tmp.txt','w')
for t in range(100):
    n=random.randint(1,1000)
    s=""
    for i in range(n):
        s=s+chr(random.randint(97,122))
    file.write('"'+s+'"\n')
file.close()
