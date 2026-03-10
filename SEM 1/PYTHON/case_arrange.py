#arrange character:lower case first then upper case
def arrange(s):
    lower=sorted([ch for ch in s if ch.islower()])
    upper=sorted([ch for ch in s if ch.isupper()])
    return ''.join(lower+upper)
s=input("Enter a string: ")
print(arrange(s))