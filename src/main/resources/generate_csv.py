# Creating a CSV file with 100 rows: username,password
import pandas as pd
rows = [{"username": f"orgon{i}", "password": "mikemike"} for i in range(1, 101)]
df = pd.DataFrame(rows)
file_path = "orgons.csv"
df.to_csv(file_path, index=False)
# Display first 10 rows for preview
