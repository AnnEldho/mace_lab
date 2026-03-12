import numpy as np
values = list(map(float, input("Enter angles(separated by spaces): ").split()))

a=np.array(values)
print("Sine values:", np.sin(a))
print("\n Cosine values:", np.cos(a))
print("\n Tangent values:", np.tan(a))