from store import billing as b
from store import discount as d
price = float(input("Enter the price of the item: "))
quantity = int(input("Enter the quantity of the item: "))
amount = b.total(price, quantity)
print(f"Amount : {amount}")
disc = d.discount(amount)
print(f"Discount : {disc}")
total_amount = amount - disc
print(f"Total Amount to be paid : {total_amount}")