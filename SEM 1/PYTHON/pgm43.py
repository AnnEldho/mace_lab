class Publisher:
    def _init_(self):
       self.name=input("Enter publisher name : ")
    def display(self):
        print("Publisher name:",self.name)

class Book(Publisher):
    def _init_(self):
        super()._init_()
        self.title=input("Enter title:")
        self.author=input("Enter author:")
    def display(self):
        super().display()
        print("Title : ",self.title)
        print("Author : ",self.author)

class Python(Book):
    def _init_(self):
        super()._init_()
        self.price=input("Enter price : ")
        self.nopages=input("Enter no: of pages : ")
    def display(self):
        super().display()
        print("Price : ",self.price)
        print("No: of pages : ",self.nopages)
try:
    b1=Python()
    print("\n_Book Details_")
    b1.display()
except Exception as e:
    print(e)