# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy only pom.xml first to leverage Docker layer caching for dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

# Build the JAR (skipping tests speeds up the build)
RUN mvn clean package -DskipTests

# Stage 2: Create the lightweight runtime image
FROM eclipse-temurin:21-jre AS runner

WORKDIR /app

# Fixed the typos: 'traget' -> 'target' and 'pateint' -> 'patient' (check your actual filename)
# Also adjusted the source path to match the WORKDIR of the builder
COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

ENTRYPOINT [ "java", "-jar", "app.jar" ]