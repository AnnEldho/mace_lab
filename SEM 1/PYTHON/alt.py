def alternate_chars(s, i=0):
    if i >= len(s):
        return
    print(s[i],end=" ")
    alternate_chars(s, i+2)

text = input("Enter text: ")
alternate_chars(text)
