# Usar una imagen base con JDK 11 y Maven
FROM openjdk:1-jdk-alpine
COPY target/serviceauth-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]