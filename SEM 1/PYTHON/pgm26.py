#Write a program that counts odd and even numbers in a given list.
numbers=input("Enter numbers separated by spaces: ").split()
even_count=0
odd_count=0
for num in numbers:
    num=int(num)
    if num%2==0:
        even_count+=1
    else:
        odd_count+=1
print("Even numbers count:", even_count)
print("Odd numbers count:", odd_count)