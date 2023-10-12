# Usa una imagen base de OpenJDK
FROM openjdk:11-jre-slim

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu proyecto Spring Boot al contenedor
COPY target/serviceauth-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]