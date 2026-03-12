import numpy as np # Visualize Optimization Path
from scipy.optimize import minimize
import matplotlib.pyplot as plt
def objective_function(x):
    return x**2 + 10*np.sin(x)
# Initial guess
x0 = 2
# Find the minimum uses BFGS Optimization algorithm
result = minimize(objective_function, x0)
# Generate x values for plotting
x = np.linspace(-5, 5, 100)
y = objective_function(x)

# Plot the function
plt.plot(x, y)
# Plot the initial point
plt.scatter(x0, objective_function(x0), color='red', label='Initial Point')
# Plot the final point
plt.scatter(result.x, result.fun, color='green', label='Minimum Point')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Optimization Path')
plt.legend()
plt.grid(True)
plt.show()
