import random
n=1000
for t in range(100):
    s=""
    for i in range(n):
        s=s+str(random.randint(0,1))
    x = random.randint(1,500)
    print('"'+s+'"')
    print(x)
