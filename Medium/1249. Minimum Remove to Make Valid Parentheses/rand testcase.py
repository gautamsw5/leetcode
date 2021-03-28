import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(5):
    n=random.randint(1,10**5)
    s=""
    for i in range(n):
        x = random.randint(1,5)
        c=""
        if x<2:
            c = chr(random.randint(97,122))
        else:
            x = random.randint(0,1)
            if x == 0:
                c = '('
            else:
                c = ')'
        s=s+c
    file.write('"'+s+'"\n')
file.close()
