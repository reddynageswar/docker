FROM node:18 AS build
WORKDIR /app

# Copy dependencies first (caching)
COPY package.json package-lock.json ./

RUN npm install

# Copy all frontend files
COPY . .

# Build React project
RUN npm run build

# Serve with Nginx
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
