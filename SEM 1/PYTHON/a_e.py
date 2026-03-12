lines = []

with open("input.txt") as f:
    for line in f:
        words = line.split()
        remove = False
        for w in words:
            if w.lower().startswith('a') and w.lower().endswith('e'):
                remove = True
                break
        if not remove:
            lines.append(line)

with open("output.txt", "w") as f:
    f.writelines(lines)