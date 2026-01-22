class Person:
    def __init__(self, name, roll):
        self.name = name
        self.roll = roll

class Marks:
    def __init__(self, maths, computer):
        self.maths = maths
        self.computer = computer

class Student(Person, Marks):
    def __init__(self, name, roll, maths, computer):
        Person.__init__(self, name, roll)
        Marks.__init__(self, maths, computer)

    def result(self):
        avg = (self.maths + self.computer) / 2
        print("Pass" if avg >= 50 else "Fail")

s = Student("Ann", 1, 50, 40)
s.result()
