def alternative(s,i=0):
    if i >= len(s):
        return""
    
    return s[i]+alternative(s,i+2)

text="HelloWorld"
print(alternative(text))