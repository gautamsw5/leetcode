file = open('tmp.txt','r')
filew = open('tmpp.txt','w')
for line in file:
    i=0
    s='"'
    while i<len(line):
        if ord(line[i])>64 and ord(line[i])<91:
            s=s+line[i]
        i=i+1
    s=s+'"'
    if len(s)>2:
        filew.write(s+'\n')
filew.close()
file.close()
