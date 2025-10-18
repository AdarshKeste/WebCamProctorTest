# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
CMD ["java","-jar","target/WebCamProctorTest-0.0.1-SNAPSHOT.jar"]