def insert(a,b):
    x=-2
    n=len(a)
    for i in range(n-1):
        if a[i][0]==b[0]:
            x=i
            break
        if b[0]>a[i][1] and a[i+1][0]<=b[1]:
            x=i+1
            break
        if a[i][0]>b[0]:
            x=i-1
            break
    if x==-2:
        if a[n-1][1]<b[1]:
            a[n-1][1]=b[1]
        return a
    if x==-1:
        if a[0][1]>=b[1]:
            a[0][0]=b[0]
            return a
        else:
            a.insert(0,b)
            return a
    #m=[a[x][0],a[x][1]]
    if a[x][1]<b[1]:
        a[x][1]=b[1]
    else:
        return a
    i=x
    while i<n-1:
       #i+1,i
        if a[i][1]>=a[i+1][0]:
            a[i][1]=max(a[i][1],a[i+1][1])
            del a[i+1]
            n=n-1
        else:
            break
    return a
a=[[],[],[]]
b=[]
#print(insert(a,b))
def test(a,n,x):
    i=x
    while i<n-1:
       #i+1,i
        if a[i][1]>=a[i+1][0]:
            a[i][1]=max(a[i][1],a[i+1][1])
            del a[i+1]
            n=n-1
        else:
            i=i+1
    return a
x=1
n=3
a=[[1,2],[2.5,3],[3,4]]
print(test(a,n,x))
