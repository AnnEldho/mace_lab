#generate all factors of a given number
num=int(input("Enter a number:"))
if num>0:
    print("factors of",num,"are:",)   
    for i in range(1,num+1):
       if num % i == 0:
            print(i)
else:
    print("enter a positive number!!")
    

    