import math

class Complex:
    def __init__(self):
        self.__real = float(input("Enter real part: "))
        self.__imag = float(input("Enter imaginary part: "))

    def __ge__(self, other):
        mag1 = math.sqrt(self.__real**2 + self.__imag**2)
        mag2 = math.sqrt(other.__real**2 + other.__imag**2)
        return mag1 >= mag2

    def display(self):
        print(f"Complex Number: {self.__real} + {self.__imag}i")


# Main program
try:
    print("--- Enter First Complex Number ---")
    c1 = Complex()
    print("--- Enter Second Complex Number ---")
    c2 = Complex()

    print("\nComparing Magnitude:")
    if c1 >= c2:
        print("First complex number is greater or equal.")
    else:
        print("Second complex number is greater.")

except Exception as e:
    print("Error:", e)
