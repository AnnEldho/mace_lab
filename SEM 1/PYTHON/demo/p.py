import re
p=re.compile(r'\b[6-9]\d{9}\b')
f=open("f1.py",'r+')
l=f.read()
nums=p.findall(l)
f.truncate(0)   
f.seek(0)
print ("Phone Numbers found:", nums)
for i in nums:
    f.write(i+'\n')
f.close()