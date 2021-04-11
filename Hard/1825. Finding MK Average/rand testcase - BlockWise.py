import random
##with open('tmp.txt','w'): pass
##file = open('tmp.txt','w')
xrr = ["calculateMKAverage","addElement"]
low = 1
high = 100
T = 10
M = 10**5
for t in range(T):
    with open('t'+str(t)+'.txt','w'): pass
    file = open('t'+str(t)+'.txt','w')
    m=7
    k=2
    m = random.randint(3, M)
    k = random.randint(1, m//2 - 1)
    srr = ["MKAverage"]
    arr = [[m,k]]
    n = min(10**5, m*3)
    for i in range(n):
        if random.randint(0,10)!=10:
            srr.append(xrr[1])
            x = random.randint(low,high)
            arr.append([x])
        else:
            srr.append(xrr[0])
            arr.append([])
    file.write(str(srr).replace(" ","").replace("'",'"')+'\n')
    file.write(str(arr).replace(" ","")+'\n')
    file.close()
##file.close()
