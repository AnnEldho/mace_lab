number=int(input("Enter a number:"))
fact=1
if number>0:
    for f in range(1,number+1):
        fact*=f      
    print("factorial:",fact)  
else:
    print("Enter a positive number!!")        
