# Start with a valid OpenJDK 17 slim base image
FROM openjdk:17-slim

# Set a working directory inside the container
WORKDIR /app

# Copy the compiled jar from target folder
COPY target/BankProject-0.0.1-SNAPSHOT.jar BankProject.jar

# Expose port (optional, if your app uses a port, e.g., 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "BankProject.jar"]
