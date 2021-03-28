e="0+"+input()+"+0"
x1=0
y1=0
x2=0
y2=0
i=0
while(i<len(e)):
    print(e[i])
    s="+"
    if(e[i]=='+'):
        s="+"
        i=i+1
    if(e[i]=='-'):
        s="-"
        i=i+1
    while(i<len(e) and e[i].isnumeric()):
        s=s+e[i]
        i=i+1
    if(i<len(e)):
        if(e[i]=='=' and len(s)==1):
            break
        if(len(s)==1):
            s=s+"1"
        if(e[i]=='x'):
            x1+=int(s)
        else:
            y1+=int(s)
    else:
        break
    if(e[i]=='='):
        i=i+1
        break
    if(e[i]!='-' and e[i]!='+'):
        i=i+1
if(e[i]=='='):
    i=i+1
print(e[i])
while(i<len(e)):
    s="+"
    print(e[i])
    if(e[i]=='+'):
        s="+"
        i=i+1
    if(e[i]=='-'):
        s="-"
        i=i+1
    while(i<len(e) and e[i].isnumeric()):
        s=s+e[i]
        i=i+1
    if(i<len(e) and e[i]!='='):
        if(len(s)==1):
            s=s+"1"
        if(e[i]=='x'):
            x2+=int(s)
        else:
            y2+=int(s)
    else:
        break
    if(e[i]=='='):
        i=i+1
        break
    if(e[i]!='-' and e[i]!='+'):
        i=i+1
'''s='0'
i=0
while(i<len(b)):
    if(b[i]=='+'):
        i=i+1
    elif(b[i]=='-' and b[i+1]=='x'):
        s='-1'
        i=i+1
    while(i<len(b) and str(b[i]).isnumeric()):
        s=s+b[i]
        i=i+1
    if(i<len(b) and b[i]=='x'):
        if(len(s)>1):
            x2=x2+int(s)
        else:
            x2=x2+1
    else:
        y2=y2+int(s)
    #print(i,s)
    if(i<len(b) and b[i]=='-'):
            s='-'
        #print("here")
    else:
        s='0'
    i=i+1'''
if x1==x2 and y1==y2:
    print("Infinite solutions")
elif x1==x2 and y1!=y2:
    print("No solution")
else:
    print("x="+str((y2-y1)//(x1-x2)))
