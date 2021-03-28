import random
file = open('tmp.txt','w')
for t in range(50):
    n=random.randint(1,1) # 10**3 # 10**5
    arr=[]
    lim = random.randint(1,10**6)
    gl = random.randint(-10**9,10**9)
    for i in range(n):
        arr.append(random.randint(-lim,lim))
    file.write(str(arr).replace(" ","")+'\n'+str(lim)+'\n'+str(gl)+'\n')
file.close()
