# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Grant execute permission to mvnw and build project
RUN chmod +x ./mvnw && ./mvnw -DskipTests clean install -B

# Stage 2: Runtime
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (ajusta según tu aplicación)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
