# Use a Maven image to build the application
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files into the container
COPY pom.xml ./
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK image to run the application
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# command used to test: docker run -p 8080:8080 oracle-challenge-app