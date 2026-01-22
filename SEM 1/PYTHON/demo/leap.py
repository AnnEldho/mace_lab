year=int(input("Enter future year:"))
y=[i for i in range(2026,year+1) if (i%4==0 and i%100!=0) or (i%400==0)]
print("Leap years:",y)