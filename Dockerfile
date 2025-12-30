# Use Eclipse Temurin 17 JDK slim image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the compiled JAR into the container
COPY target/BankProject-0.0.1-SNAPSHOT.jar BankProject.jar

# Expose port if needed (e.g., if your app listens on 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "BankProject.jar"]
