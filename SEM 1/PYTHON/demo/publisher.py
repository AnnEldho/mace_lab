class Publisher:
    def __init__(self):
        self.name = input("Enter publisher name: ")
        self.address = input("Enter publisher address: ")
    def display(self):
        print(f"Publisher Name: {self.name}")
        print(f"Publisher Address: {self.address}")
class Book():
    def __init__(self):
        self.title = input("Enter book title: ")
        self.author = input("Enter book author: ")
        self.price = float(input("Enter book price: "))
    def display(self):
        super().display()
        print(f"Book Title: {self.title}")
        print(f"Book Author: {self.author}")
        print(f"Book Price: {self.price}")
class Python(Book, Publisher):
    def __init__(self):
        Publisher.__init__(self)
        super().__init__()
    def display(self):
        Publisher.display(self)
        super().display()
try:
    b = Python()
    b.display()
except Exception as e:
    print("Error:", e)  
finally:
    print("Execution completed.")