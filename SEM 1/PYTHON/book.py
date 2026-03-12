class Book:
    def __init__(self,title,author):
        self.title=title
        self.author=author

b1=Book("Python","John")
b1.publisher=("ABC")

if hasattr(b1,'publisher'):
    print(f"{b1.title} written by {b1.author} published by {b1.publisher}")
else:
    print("Unknown Book") 
