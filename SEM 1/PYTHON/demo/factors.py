import numpy as np
number =int(input("Enter  a number:"))
factors=[]
for i in range(1,number+1):
    if number%i==0:
        factors.append(i)
arr=np.array(factors)
print("The factors of the number are(np array):",arr)