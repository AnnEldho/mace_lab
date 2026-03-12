class Person:
    def __init__(self):
        self.__name = input("Enter name: ")
        self.__age = int(input("Enter age: "))

    def __lt__(self, other):
        return self.__age < other.__age

    def display(self):
        print(f"Name: {self.__name}, Age: {self.__age}")


# Main program
try:
    print("--- Enter First Person ---")
    p1 = Person()
    print("--- Enter Second Person ---")
    p2 = Person()

    if p1 < p2:
        print("Second person is older.")
    elif p2 < p1:
        print("First person is older.")
    else:
        print("Both are of the same age.")

except Exception as e:
    print("Error:", e)
