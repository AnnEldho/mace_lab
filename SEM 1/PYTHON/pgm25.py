#Write a program that count the number of strings where string length is 2
#  or more and the first and last characters are same.
strings = input("Enter strings separated by spaces: ").split()
count = 0
for s in strings:
    if len(s) >= 2 and s[0] == s[-1]:
        count += 1
print("Number of strings with length 2 or more and same first and last character:", count)