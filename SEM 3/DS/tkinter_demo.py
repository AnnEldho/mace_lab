import tkinter as tk

root = tk.Tk()

root.title("Tkinter Demo")
root.geometry("300x200")

label = tk.Label(root, text="Welcome to Tkinter")
label.pack(pady=20)

button = tk.Button(root, text="Click Me")
button.pack()

root.mainloop()