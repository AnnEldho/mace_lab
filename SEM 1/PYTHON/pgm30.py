#Write recursive functions to 
# (a) find the factorial of a number 
n1=int(input("Enter a number to find factorial: "))
def factorial(n1):
    if n1==0 or n1==1:
        return 1
    else:
        return n1*factorial(n1-1)
print("Factorial of",n1,"is",factorial(n1))

# (b) find the nth Fibonacci number 
n2=int(input("Enter a number to find nth Fibonacci number: "))
def fibonacci(n2):
    if n2<=0:
        return "Invalid input"
    elif n2==1:
        return 0
    elif n2==2:
        return 1
    else:
        return fibonacci(n2-1)+fibonacci(n2-2)
print("The",n2,"th Fibonacci number is",fibonacci(n2))

# (c) find the sum of an integer list 
def sum_list(lst):
    if len(lst) == 0:
        return 0
    else:
        return lst[0] + sum_list(lst[1:])
print("Sum of list:", sum_list([1, 2, 3, 4, 5])) 

# (d) find the sum of first N whole numbers 
n3=int(input("Enter a number to find sum of first N whole numbers: "))
def sum_n(n3):
    if n3==0:
        return 0
    else:
        return n3 + sum_n(n3-1)
print("Sum of first",n3,"whole numbers is",sum_n(n3))       

# (e) reverse a string.
s=input("Enter a string to reverse: ")
def reverse_string(s):
    if len(s) == 0:
        return s
    else:
        return s[-1] + reverse_string(s[:-1])
print("Reversed string is:",reverse_string(s))