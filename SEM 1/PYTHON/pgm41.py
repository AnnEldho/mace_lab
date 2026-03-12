class Rectangle:
    def __init__(self, l=1, b=1):
        self.__length = l
        self.__breadth = b

    def area(self):
        return self.__length * self.__breadth

    def __lt__(self, other):
        return self.area() < other.area()

try:
    l1 = int(input("Enter length of Rectangle 1: "))
    b1 = int(input("Enter breadth of Rectangle 1: "))
    r1 = Rectangle(l1, b1)

    l2 = int(input("\nEnter length of Rectangle 2: "))
    b2 = int(input("Enter breadth of Rectangle 2: "))
    r2 = Rectangle(l2, b2)

    print(f"Area of Rectangle 1 = {r1.area()}")
    print(f"Area of Rectangle 2 = {r2.area()}")

    if r1 < r2:
        print(" Area of Rectangle 1 is smaller ")
    
    elif r2 < r1:
        print(" Area of Rectangle 2 is smaller")
    else:
        print(" Both rectangles have equal area")

except Exception as e:
    print(e)
