# 	Write lambda functions:
#(a) To find largest of 2 numbers
a=int(input("Enter first number: "))
b=int(input("Enter second number: "))
largest=lambda a,b: a if a>b else b
print("The largest number is:",largest(a,b))
#(b)  To check the input number is divisible by 5
num=int(input("Enter a number: "))
divisible=lambda x:x%5==0
if divisible(num):
    print(num,"is divisible by 5")
else:
    print(num,"is not divisible by 5")
#(c) To remove all strings with length < 5 from a list of strings
strings=input("Enter strings separated by spaces: ").split()
removed=lambda str: [s for s in str if len(s)>=5]
result=removed(strings)
print("List after removing strings with length < 5:", result)
#(d)  To increment a list of integers by 10% if the number is greater than 1000 else by 5%.
number=input("Enter numbers:").split()

for n in number:
    increment=list(map(lambda n:int(n)*0.1+int(n) if int(n)>1000 else int(n)+int(n)*0.05,number))
print("Incremented salaries:",increment)
