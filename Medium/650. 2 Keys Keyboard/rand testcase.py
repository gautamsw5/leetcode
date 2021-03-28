import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(1000):
    file.write(str(t)+'\n')
file.close()
