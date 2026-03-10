#find the sum of even valued terms in fibonacci series

print("FIBONACCI SERIES")
n = int(input("Enter the number of terms: "))

a, b = 0, 1
total=0
print("Fibonacci series: ")
for i in range(n):
    if(a%2 == 0):
        total+=a
    print(a,end=" ")
    a, b = b, a + b
print("\nSum of even numbers in fibonacci series upto limit",n,"=",total)
