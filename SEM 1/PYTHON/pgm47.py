class FruitBasket:
    def __init__(self):
        self.fruits = {}
        n = int(input("Enter number of fruits: "))
        for _ in range(n):
            name = input("Enter fruit name: ")
            price = float(input("Enter price per kg: "))
            self.fruits[name.lower()] = price

    def __add__(self, other):
        result = FruitBasket.__new__(FruitBasket)
        result.fruits = {}
        all_fruits = set(self.fruits) | set(other.fruits)
        for fruit in all_fruits:
            price1 = self.fruits.get(fruit, float('inf'))
            price2 = other.fruits.get(fruit, float('inf'))
            result.fruits[fruit] = min(price1, price2)
        return result

    def display(self):
        print("\n--- Fruit Basket Details ---")
        for fruit, price in self.fruits.items():
            print(f"{fruit.capitalize()}: ₹{price}")


# Main program
try:
    print("--- Enter First Basket ---")
    b1 = FruitBasket()
    print("--- Enter Second Basket ---")
    b2 = FruitBasket()

    b3 = b1 + b2
    b3.display()
    
except Exception as e:
    print("⚠️ Error:", e)
