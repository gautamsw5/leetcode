import random
with open('tmp.txt','w'): pass
file = open('tmp.txt','w')
for t in range(5000):
    n=random.randint(1,12)
    coins = []
    amount = random.randint(1,10000)
    for i in range(n):
        coins.append(random.randint(1,amount))
    file.write(str(coins)+'\n'+str(amount)+'\n')
file.close()
