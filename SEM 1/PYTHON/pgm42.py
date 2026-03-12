class Time:
    def __init__(self, h=0, m=0, s=0):
        self.__hour = h
        self.__minute = m
        self.__second = s

    def __str__(self):
        return "{:02d}:{:02d}:{:02d}".format(self.__hour, self.__minute, self.__second)

    def __add__(self, other):
        h = m = s = 0
        s = (self.__second + other.__second) % 60
        m = (self.__second + other.__second) // 60
        m += (self.__minute + other.__minute) % 60
        h = (self.__minute + other.__minute) // 60
        h += (self.__hour + other.__hour) % 12
        return Time(h, m, s)


try:
    print("Enter details for Time 1:")
    h1 = int(input("Hour: "))
    m1 = int(input("Minute: "))
    s1 = int(input("Second: "))
    t1 = Time(h1, m1, s1)

    print("\nEnter details for Time 2:")
    h2 = int(input("Hour: "))
    m2 = int(input("Minute: "))
    s2 = int(input("Second: "))
    t2 = Time(h2, m2, s2)

    t3 = t1 + t2

    print(f"Time 1 = {t1}")
    print(f"Time 2 = {t2}")
    print(f"Sum of Time = {t3}")

except Exception as e:
    print(e)
