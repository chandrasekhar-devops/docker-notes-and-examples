# ---------------------------
# Build stage
# ---------------------------
FROM node:20-slim AS build

LABEL maintainer="CHANDRA"

WORKDIR /app

# Copy only package.json and package-lock.json first (better layer caching)
COPY package*.json ./

# Install build tools for native modules
RUN npm install --legacy-peer-deps

# Copy the rest of the source code
COPY . .

# Build React app
RUN npm run build

# ---------------------------
# Nginx stage
# ---------------------------
FROM nginx:alpine

# Copy React build from previous stage
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]

