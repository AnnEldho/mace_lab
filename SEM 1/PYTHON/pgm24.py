#Write a program to remove all odd indexed characters from a given string.
string=input("Enter a string: ")
even_indexed=string[::2]
print("String after removing odd indexed characters:", even_indexed)