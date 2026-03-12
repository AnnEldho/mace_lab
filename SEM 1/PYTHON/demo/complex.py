import math
class Complex:
    def __init__(self):
        self.real=float(input("Enter the real part: "))
        self.imag=float(input("Enter the imaginary part: "))
    def display(self):
        print(f"The complex number is: {self.real} + {self.imag}i") 
    def __ge__(self,other):
        mag1=math.sqrt(self.real**2 + self.imag**2)
        print("mag1:", mag1)
        mag2=math.sqrt(other.real**2 + other.imag**2)
        print("mag2:", mag2)
        return mag1 >= mag2
try:
    print("Creating first complex number:")
    c1=Complex()
    print("Creating second complex number:")
    c2=Complex()
    print("First complex number:")
    c1.display()
    print("Second complex number:")
    c2.display()
    if c1>=c2:
        print("First complex number has greater or equal magnitude than second.")
    else:
        print("Second complex number has greater magnitude than first.")
except Exception as e:
    print("Error:", e)