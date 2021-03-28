class Solution:
    def trap(a):
        i=0
        j=0
        k=0
        m=0
        s=0
        s1=0
        s2=0
        n=len(a)
        if n<=2:
            return 0
        '''if n==3:
            if (a[1]>=a[0] and a[1]>=a[2]) or min(a[0],a[2])<=a[1]:
                return 0
            else:
                return min(a[0],a[2])-a[1]'''
        if a[0]<=a[1]:
            while a[i]<=a[i+1]:
                del a[i]
                n=n-1
                if n<=2:
                    return 0
        print(a)
        if a[n-2]>=a[n-1]:
            while n>1 and a[n-2]>=a[n-1]:
                del a[n-1]
                n=n-1
                if n<=2:
                    return 0
        print(a)
        if n<=2:
            return 0
        '''if n==3:
            if (a[1]>=a[0] and a[1]>=a[2]) or min(a[0],a[2])<=a[1]:
                return 0
            else:
                return min(a[0],a[2])-a[1]'''
        '''i=0
        print(a)
        while i<n:
            j=i+1
            s1=0
            while j<n:
                if a[j]<a[i]:
                    s1=s1+a[i]-a[j]
                    print(a[i]-a[j])
                else:
                    s=s+s1
                    i=j
                    break
                j=j+1
            i=j
        i=0
        a.reverse()
        while i<n:
            j=i+1
            s1=0
            while j<n:
                if a[j]<=a[i]:
                    s1=s1+a[i]-a[j]
                    print(a[i]-a[j])
                else:
                    s=s+s1
                    i=j
                    break
                j=j+1
            i=j'''
        i=0
        k=n-1
        while i<n or k>=0:
            j=i+1
            m=k-1
            s1=0
            s2=0
            while j<n and i<n:
                if a[j]<a[i]:
                    s1=s1+a[i]-a[j]
                else:
                    s=s+s1
                    i=j
                    break
                j=j+1
            i=j
            while m>=0 and k>=0:
                if a[m]<=a[k]:
                    s2=s2+a[k]-a[m]
                else:
                    s=s+s2
                    k=m
                    break
                m=m-1
            k=m
        return s
    a=list(map(int,input().split()))
    #a=[0,1,0,2,1,0,1,3,1,2,1]
    #print(a)
    #trap(a)
    print(trap(a))
