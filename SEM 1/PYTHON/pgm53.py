import numpy as np
a=np.array([[10, 20, 30],
                [40, 50, 60]])
print("Original 2D Array:")
print("\nsum of all elements:", np.sum(a))
print("\nsum of columns:", np.sum(a, axis=0))
print("\nsum of rows:", np.sum(a, axis=1))

print("\nCumulative sum of all elements:", np.cumsum(a))

print("\nmaximum element:",np.max(a))
print("\nmaximum of each column:", np.max(a, axis=0))
print("\nmaximum of each row:", np.max(a, axis=1))

print("\nminimum element:", np.min(a))
print("\nminimum of each column:", np.min(a, axis=0)) 
print("\nminimum of each row:", np.min(a, axis=1))
