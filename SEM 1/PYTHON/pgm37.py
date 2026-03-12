filename=input("Enter filename:")
file=open(filename,'r')
lines=file.readlines()
file=open(filename,'w')
for line in lines:
    if not line.strip().startswith('#'):
        file.write(line)
file.close()
print("Comments removed successfully.")