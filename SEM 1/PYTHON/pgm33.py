inf = False
try:
    inf = open('abc.txt', encoding='utf-8')
    lines = inf.readlines()
    print("File contents:")
    print(lines)
    print("Number of lines:", len(lines))
except IOError as io:
    print("Error:", io)
finally:
    if inf:
        inf.close()
