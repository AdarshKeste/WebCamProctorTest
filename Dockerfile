# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy all project files into the image
COPY . .

# Build the project using Maven Wrapper
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the compiled application
CMD ["java", "-jar", "target/WebCamProctorTest-0.0.1-SNAPSHOT.jar"]