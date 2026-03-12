class Rectangle:
    def __init__(self):
        self.l = float(input("Enter length: "))
        self.b = float(input("Enter breadth: "))
    def area(self):
        return self.l * self.b
    def perimeter(self):
        return 2 * (self.l + self.b)
    def __le__(self,other):
        return self.area() <= other.area()
    def __ge__(self,other):
        return self.area() >= other.area()

try:
    r1 = Rectangle()
    print("Area:", r1.area())
    print("Perimeter:", r1.perimeter())

    r2 = Rectangle()
    print("Area:", r2.area())   
    print("Perimeter:", r2.perimeter())

    if r1.area() > r2.area():
        print("Rectangle 1 has a larger area.")
    elif r1.area() < r2.area():
        print("Rectangle 2 has a larger area.")
except Exception as e:
    print("Error:", e)
finally:
    print("Execution completed.")