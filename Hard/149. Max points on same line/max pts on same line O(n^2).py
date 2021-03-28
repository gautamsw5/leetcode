class Solution:
    #def maxPoints(self, points: List[List[int]]) -> int:
    def maxPoints(points):
        def gcd(a,b):
            if b==0:
                return a
            return gcd(b,a%b)
        def getline(a,b):
            if a[0]==b[0]:
                return (0,0)
            elif a[1]==b[1]:
                return (10**30,10**30)
            m1=a[0]-b[0]
            m2=a[1]-b[1]
            if m2<0:
                m2=-m2
                m1=-m1
            g=gcd(abs(m1),abs(m2))
            return (m1//g,m2//g)
        if len(points)<3:
            return len(points)
        freq={}
        for i in points:
            if tuple(i) in freq:
                freq[tuple(i)]+=1
            else:
                freq[tuple(i)]=1
        ans=2
        points=[]
        for i in freq:
            points.append(i)
        for i in range(0,len(points)):
            lines={}
            for j in range(i+1,len(points)):
                line=getline(points[i],points[j])
                if line in lines:
                    lines[line]+=freq[points[j]]
                else:
                    lines[line]=freq[points[i]]+freq[points[j]]
                if ans<lines[line]:
                    ans=lines[line]
            if ans<freq[points[i]]:
                ans=freq[points[i]]
        return ans
