# --- Stage 1: Build Environment ---
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy pom.xml and source files to build application
COPY pom.xml .
COPY src ./src

# Compile and package the application into a JAR file, skipping tests for fast compilation
RUN mvn clean package -DskipTests

# --- Stage 2: Optimized Production Run Environment ---
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the built JAR asset from the builder stage to reduce final container size
COPY --from=builder /app/target/*.jar app.jar

# Expose the standard microservice web container interface port
EXPOSE 8080

# Configure execution entry point parameters
ENTRYPOINT ["java", "-jar", "app.jar"]
