import numpy as np

# 2D array (matrix)
arr2d = np.array([[10, 20, 30],
                  [40, 50, 60],
                  [70, 80, 90]])

print("Original 2D Array:")
print(arr2d)

# Slicing examples
print("\n1. First two rows:")
print(arr2d[0:2, :])

print("\n2. First two columns:")
print(arr2d[:, 0:2])

print("\n3. Middle element (row 1, col 1):")
print(arr2d[1, 1])

print("\n4. Sub-matrix (rows 0-1, cols 1-2):")
print(arr2d[0:2, 1:3])
