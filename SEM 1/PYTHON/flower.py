class Flower:
    def __init__(self,name):
        self.name=name
name=input("Enter flower name: ")
f=Flower(name)
if(input("Does it have petalColor?" ))== 'yes':
    f.petalColor= input("enter petal color: ")

print(f"{f.petalColor} {f.name}" if hasattr (f,"petalColor") else "Unknown flower")