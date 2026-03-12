import pandas as pd

# Sample DataFrame
data = {
    'Name': ['John', 'Maria', 'Kevin'],
    'Age': [25, 23, 24]
}

df = pd.DataFrame(data)

# New row to insert
new_row = {'Name': 'Sophia', 'Age': 22}

# Position to insert (0-based index)
position = 2

# Insert the row
df = pd.concat([df.iloc[:position], pd.DataFrame([new_row]), df.iloc[position:]]).reset_index(drop=True)

print(df)
