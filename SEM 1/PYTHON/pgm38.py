import re

# Compile pattern
p = re.compile(r'\b[6-9]\d{9}\b')

# Open file and read content
f = open("phones.txt", "r")
data = f.read()

# Find and print matching numbers
nums = p.findall(data)
print("Phone numbers starting with 6,7,8,9:")
for n in nums:
    print(n)

f.close()
