for num in range(100,500):
    digit=list( map(int,str(num)))
    if sum(d** 3 for d in digit) ==num :
        print(num)