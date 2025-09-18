# Official Python base image
FROM python:3.11-slim

# Maintainer info
LABEL maintainer="CHANDRA"

# Set work directory inside container
WORKDIR /app

# Copy requirements.txt
COPY requirements.txt .

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy entire code
COPY . .

# Expose port for Flask
EXPOSE 5000

# Run the app (ENTRYPOINT could also be used)
CMD ["python", "app.py"]

