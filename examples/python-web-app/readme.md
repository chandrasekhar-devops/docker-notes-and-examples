# 🚀 Dockerizing a Python Web App

This guide demonstrates how to containerize a simple Python Flask web application using **Docker**.

---

## 📂 Project Structure

Either clone an existing Python web app from GitHub or create a new one for demo:

```bash
$ mkdir python-web-app
$ cd python-web-app
```


---

## 📝 Create Application Files

### `app.py`
```python
from flask import Flask

app = Flask(__name__)

@app.route("/")
def home():
    return "Hello from Dockerized Flask App! Telusko Learning"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
```
### `requirements.txt`
```
flask
```
### `Dockerfile`
```
# Official python base image
FROM python:3.11-slim

# Maintainer info
LABEL maintainer="SATYASHEEL"

# Set working directory
WORKDIR /app

# Copy dependency file
COPY requirements.txt .

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy application code
COPY . .

# Expose Flask port
EXPOSE 5000

# Run the application
CMD ["python", "app.py"]
```
### `⚙️ Build & Run Docker Image`
```
docker build -t python-flask-app .
```
### `Verify image is created`
```
docker images
```
### `Expected output:`
```
REPOSITORY         TAG       IMAGE ID       CREATED          SIZE
python-flask-app   latest    036b8f5bf7c7   11 minutes ago   140MB
```
### `Run the container`
```
docker run -d -p 5000:5000 python-flask-app
```
### `Check running container`
```
docker ps
```
### `🌍 Access the Application`

### `On local machine:`
```
curl http://localhost:5000
```
#### `On EC2 instance (ensure Security Group allows port 5000):`
```
http://<public-ip>:5000

```
### `✅ You should see:`
```
Hello from Dockerized Flask App! Telusko Learning
```

### 🎉 Congratulations! You have successfully Dockerized a Python Flask app.
