class Rectangle:
    def __init__(self, l, b):
        self.length = l
        self.breadth = b

    def area(self):
        return self.length * self.breadth

    def perimeter(self):
        return 2 * (self.length + self.breadth)

    def __lt__(self, other):   # Overload '<'
        return self.area() < other.area()

    def __gt__(self, other):   # Overload '>'
        return self.area() > other.area()


# Main program
try:
    l1 = int(input("Enter length of Rectangle 1: "))
    b1 = int(input("Enter breadth of Rectangle 1: "))
    r1 = Rectangle(l1, b1)

    l2 = int(input("\nEnter length of Rectangle 2: "))
    b2 = int(input("Enter breadth of Rectangle 2: "))
    r2 = Rectangle(l2, b2)

    print("\nArea of Rectangle 1 =", r1.area())
    print("Perimeter of Rectangle 1 =", r1.perimeter())
    print("Area of Rectangle 2 =", r2.area())
    print("Perimeter of Rectangle 2 =", r2.perimeter())

    if r1 > r2:
        print("\nRectangle 1 has a greater area")
    elif r1 < r2:
        print("\nRectangle 1 has a smaller area")
    else:
        print("\nBoth rectangles have equal area")

except Exception as e:
    print(e)
