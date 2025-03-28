# Layer 1: Base image (Existing Layer from Docker Hub)
FROM ubuntu:latest 

# Layer 2: Updates the package list
RUN apt update 

# Layer 3: Installs Nginx
RUN apt install -y nginx  

# Layer 4: Copies files from the host to the container
COPY index.html /var/www/html/  

# Layer 5: Exposes port 80
EXPOSE 80  

# Layer 6: Sets the default command
CMD ["nginx", "-g", "daemon off;"]
