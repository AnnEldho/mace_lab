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



# 3D array (2 blocks, each 3x3)
arr3d = np.array([
    [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]],

    [[10, 11, 12],
     [13, 14, 15],
     [16, 17, 18]]
])

print("Original 3D Array:")
print(arr3d)

# Slicing examples
print("\n1. First block:")
print(arr3d[0])

print("\n2. Second block, first row:")
print(arr3d[1, 0])

print("\n3. All blocks, second column:")
print(arr3d[:, :, 1])

print("\n4. First block, elements from middle to last:")
print(arr3d[0, 1:, 1:])

