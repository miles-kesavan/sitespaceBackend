FROM openjdk:8
EXPOSE 8080
ADD target/employee-service-0.0.1-SNAPSHOT.jar employee-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "employee-service-0.0.1-SNAPSHOT.jar"]