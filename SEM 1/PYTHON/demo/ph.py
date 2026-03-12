import re
f1=False
p=re.compile(r'\b[6-9]\d{9}\b')
try:
    f1=open("ph.txt",'r+')
    l=f1.read()
    nums=p.findall(l)
    f1.truncate(0)
    f1.seek(0)
    print ("Phone Numbers found:")
    for i in nums:
        f1.write(i+'\n')
except Exception as e:
    print("Error:",e)
finally:
    if f1:
        f1.close()