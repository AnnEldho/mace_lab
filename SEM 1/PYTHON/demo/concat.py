digits=input("Enter digits: ").split()
for i in digits:
    if len(i)!=1:
        print("Invalid input")
        exit()
    else:
        number="".join(digits)
print("The concatenated number is:", number)
