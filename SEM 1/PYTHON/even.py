def even(list):
    for i in list:
        if (i%2): 
            if i == 237:
                break
            else: return i[0:]
    return i 

        
list=input("Enter the list of numbers:").split()
print("new list:",even(list))
