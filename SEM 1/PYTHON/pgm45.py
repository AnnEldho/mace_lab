class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")

class Employee(Person):
    def __init__(self, name, age, emp_id):
        super().__init__(name, age)
        self.emp_id = emp_id

    def display(self):
        super().display()
        print(f"Employee ID: {self.emp_id}")

class Faculty(Employee):
    def __init__(self, name, age, emp_id, department):
        super().__init__(name, age, emp_id)
        self.department = department

    def display(self):
        super().display()
        print(f"Department: {self.department}")

class Researcher:
    def can_do_research(self):
        print("This person can conduct research.")

class Professor(Faculty,Researcher):
    def __init__(self, name, age, emp_id, department, title):
        Faculty.__init__(self, name, age, emp_id, department)
        self.title = title

    def display(self):
        Faculty.display(self)
        print(f"Title: {self.title}")

try:
    p1 = Professor("Dr. Smith", 45, "E123", "Computer Science", "Associate Professor")
    print("\n_Professor Details_")
    p1.display()
    p1.can_do_research()        
except Exception as e:
    print("Error:", e)