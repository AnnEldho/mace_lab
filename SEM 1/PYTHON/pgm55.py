import numpy as np
import matplotlib.pyplot as plt

# Generate 1000 random samples from a normal distribution
mean = 10
std_dev = 3

samples = np.random.normal(mean, std_dev, 1000)

# Plot the histogram
plt.hist(samples, bins=30)
plt.xlabel("Values")
plt.ylabel("Frequency")
plt.title("Histogram of 1000 Random Samples (Mean=10, SD=3)")
plt.show()
 