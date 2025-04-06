from flask import Flask, jsonify
import mysql.connector
import os

app = Flask(__name__)

# Database Configuration from Environment Variables
db_config = {
    "host": os.getenv("DATABASE_HOST", "db"),
    "user": os.getenv("DATABASE_USER", "root"),
    "password": os.getenv("DATABASE_PASSWORD", "rootpassword"),
    "database": os.getenv("DATABASE_NAME", "mydb"),
}

@app.route("/")
def home():
    return jsonify({"message": "Hello from Flask Backend!"})

@app.route("/data")
def get_data():
    try:
        connection = mysql.connector.connect(**db_config)
        cursor = connection.cursor()
        cursor.execute("SELECT DATABASE();")
        result = cursor.fetchone()
        return jsonify({"database": result[0]})
    except Exception as e:
        return jsonify({"error": str(e)})
    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
