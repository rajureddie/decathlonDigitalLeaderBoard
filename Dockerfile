# Use OpenJDK 21
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Copy project source
COPY src src

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "target/DecathlonDigitalOrders-0.0.1-SNAPSHOT.jar"]
