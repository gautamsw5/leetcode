import random
file = open('tmp.txt','w')
for t in range(50):
    n = random.randint(1,1000)
    arr=[[] for i in range(n)]
    c = 3000
    for i in range(n):
        if c>=1:
            x = random.randint(1,c)
            while len(arr[i])<min(x,n):
                ap=random.randint(0,n-1)
                if not ap in arr[i]:
                    arr[i].append(ap)
                    c = c-1
    file.write(str(arr)+'\n')
file.close()
