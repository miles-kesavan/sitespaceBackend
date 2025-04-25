# Stage 1: Build the application
FROM maven:3.8.5-openjdk-8 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:8
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/fileupload-1.0.0.jar fileupload-1.0.0.jar
ENTRYPOINT ["java", "-Xmx256m", "-jar", "fileupload-1.0.0.jar"]