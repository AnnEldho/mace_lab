import numpy as np

n = int(input("Enter limit: "))
a, b = 0, 1
fib = []

while a < n:
    fib.append(a)
    a, b = b, a + b

arr = np.array(fib)
print("Fibonacci numbers as NumPy array:", arr)
