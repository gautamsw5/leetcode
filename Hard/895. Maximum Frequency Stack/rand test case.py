import random
file = open('tmp.txt','w')
for t in range(7):
    arr=["FreqStack"]
    brr=[[]]
    for i in range(10**4):
        arr.append("push")
        brr.append([random.randint(0,10**9)])
    for i in range(10**4):
        arr.append("pop")
        brr.append([])
    file.write(str(arr).replace('\'','\"')+'\n')
    file.write(str(brr).replace('\'','\"')+'\n')
file.close()
