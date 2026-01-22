import numpy as np

values=list(map(float, input("Enter numbers(separated by spaces): ").split()))
a=np.array(values)
odd_numbers = a[a % 2 != 0]
print("Odd numbers in the array:", odd_numbers)