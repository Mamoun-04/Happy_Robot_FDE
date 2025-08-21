# Use an official JDK image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project
COPY . .

# Build
RUN ./mvnw -q -DskipTests package

# Run
CMD ["java", "-jar", "target/HRFDE-0.0.1-SNAPSHOT.jar"]
