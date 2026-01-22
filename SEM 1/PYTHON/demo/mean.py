import numpy as np
import matplotlib.pyplot as plt
mean=30
sd=3
data=np.random.normal(mean,sd,1000)
plt.hist(data,bins=30)
plt.show()