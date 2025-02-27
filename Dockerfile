FROM openjdk:8
# Set working directory
WORKDIR /app

# Copy application JAR
COPY target/fileupload-1.0.0.jar /app/fileupload-1.0.0.jar

# Expose port
EXPOSE 8080

# Run application
CMD ["java", "-jar", "/app/fileupload-1.0.0.jar"]