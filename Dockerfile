# Base image
FROM maven:3.8.3-openjdk-17

# Working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the application
COPY . .

# Build the application
ARG JAR_NAME=app.jar
RUN mvn package -DskipTests && mv target/*.jar target/$JAR_NAME

# Run the application
CMD ["java", "-jar", "/app/target/app.jar"]