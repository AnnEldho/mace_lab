class Currency:
    def __init__(self):
        self.amount = float(input("Enter amount: "))
        self.unit = input("Enter currency unit (e.g., USD, INR): ")

    def __eq__(self, other):
        return self.amount == other.amount and self.unit.lower() == other.unit.lower()

try:
    print("Enter details for first currency:")
    c1 = Currency()
    print("Enter details for second currency:")
    c2 = Currency()

    if c1 == c2:
        print("Both currencies are equal.")
    else:
        print("Currencies are not equal.")

except Exception as e:
    print("Error:", e)