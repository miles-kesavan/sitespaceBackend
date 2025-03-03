FROM openjdk:8
EXPOSE 8080
ADD target/fileupload-1.0.0.jar fileupload-1.0.0.jar
ENTRYPOINT ["java", "-jar", "fileupload-1.0.0.jar"]