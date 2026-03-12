def join_items(lst, i=0):
    if i == len(lst)-1:
        return lst[i]
    return lst[i] + "-" + join_items(lst, i+1)

print(join_items(["a", "b", "c"]))
