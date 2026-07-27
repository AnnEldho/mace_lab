from flask import Flask

app = Flask(__name__)

@app.route("/")
def home():
    return "<h1>Welcome to Flask</h1>"

@app.route("/students")
def students():
    return "<h2>Student Page</h2>"

@app.route("/about")
def about():
    return "<h2>About Flask</h2>"

@app.route("/contact")
def contact():
    return "<h2>Contact Us</h2>"

if __name__ == "__main__":
    app.run(debug=True)