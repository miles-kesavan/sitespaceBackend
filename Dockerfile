# Use Maven to build the JAR inside the container
FROM maven:3.8.5-openjdk-8 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use OpenJDK to run the JAR
FROM openjdk:8
WORKDIR /app
COPY --from=builder /app/target/fileupload-1.0.0.jar fileupload-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "fileupload-1.0.0.jar"]
