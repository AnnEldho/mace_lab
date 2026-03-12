import numpy as np
import matplotlib.pyplot as plt

# Sample data in ndarray
data = np.array([40, 25, 15, 20])
labels = ['A', 'B', 'C', 'D']

# ---- Bar Chart ----
plt.bar(labels, data)
plt.title("Bar Chart")
plt.xlabel("Categories")
plt.ylabel("Values")
plt.show()

# ---- Horizontal Bar Chart ----
plt.barh(labels, data)
plt.title("Horizontal Bar Chart")
plt.xlabel("Values")
plt.ylabel("Categories")
plt.show()


# ---- Pie Chart ----
plt.pie(data, labels=labels, autopct='%1.1f%%')
plt.title("Pie Chart")
plt.show()