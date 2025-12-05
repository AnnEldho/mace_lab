class Bank:
    def __init__(self):
        self.account_number = input("Enter account number: ")
        self.account_holder = input("Enter account holder name: ")
        self.bal=float(input("Enter initial balance: "))
    def deposit(self):
        self.amount=float(input("Enter amount to deposit: "))
        self.bal += self.amount
        print(f"Amount {self.amount} deposited. New balance is {self.bal}.")
    def withdraw(self):
        self.amount=float(input("Enter amount to withdraw: "))
        if self.amount > self.bal:
            print("Insufficient balance.")
        else:
            self.bal -= self.amount
            print(f"Amount {self.amount} withdrawn. New balance is {self.bal}.")
    def display(self):
        print(f"Account Number: {self.account_number}")
        print(f"Account Holder: {self.account_holder}")
        print(f"Current Balance: {self.bal}")
try:
    b=Bank()
    while True:
        print("\n1. Deposit\n2. Withdraw\n3. Display Account Details\n4. Exit")
        choice = int(input("Enter your choice: "))
        if choice == 1:
            b.deposit()
        elif choice == 2:
            b.withdraw()
        elif choice == 3:
            b.display()
        elif choice == 4:
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")
except Exception as e:
    print("Error:", e) 
finally:
    print("Execution completed.")