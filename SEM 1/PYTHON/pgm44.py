class Engine:
    def _init_(self):
        self.__power = input("Enter engine power (in HP): ")

    def display(self):
        print("Engine Power:", self.__power, "HP")


class Wheels:
    def _init_(self):
        self.__size = input("Enter wheel size (in inches): ")

    def display(self):
        print("Wheel Size:", self.__size, "inches")


class Car(Engine, Wheels):
    def _init_(self):
        # Initialize both parent classes
        self.__model = input("Enter car model: ")
        Engine._init_(self)
        Wheels._init_(self)

    # Method overriding
    def display(self):
        print("\n_Car Details_")
        print("Car Model:", self.__model)
        Engine.display(self)
        Wheels.display(self)


# Example usage
try:
    c1 = Car()
    c1.display()
except Exception as e:
    print("Error:", e)