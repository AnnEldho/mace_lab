# Write a function to get a new string from a given string by adding ‘Is’ to the beginning of the input string.
#  If the given string already begins with ‘Is’, return the input string unchanged.
string=input("Enter a string: ")
if string.startswith("Is"):
    new_string=string
else:
    new_string="Is "+string
print("Resulting string:", new_string)