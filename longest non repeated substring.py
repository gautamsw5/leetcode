def lengthOfLongestSubstring(s):
    n=len(s);
    a=[]
    i=0
    rl=0
    if n==1:
        return n
    if n==2:
        if s[0]==s[1]:
            return 1
        else:
            return 2
    for i in range(n):
        s1=""
        for j in range(i,n):
            if s[j] in s1:
                break
            s1+=s[j]
            if len(s1)>rl:
                rl=len(s1)
    return rl
print(lengthOfLongestSubstring("aab"))
