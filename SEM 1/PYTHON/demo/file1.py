f1=False
try:
    f1=open("f2.py",'r+')
    lines=f1.readlines()
    f1.truncate(0)
    f1.seek(0)
    for i in lines:
        if not i.strip().startswith('#'):
            f1.write(i)
    
except Exception as e:
    print("Error:",e)
finally:
    if f1:
        f1.close()