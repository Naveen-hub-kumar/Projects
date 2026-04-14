import mysql.connector

conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="root",
    database="testdb"
)

cursor = conn.cursor()

# Insert
cursor.execute("INSERT INTO student values('Bharath')")
conn.commit()

# Fetch
cursor.execute("SELECT * FROM student")
rows = cursor.fetchall()

for r in rows:
    print(r)

conn.close()