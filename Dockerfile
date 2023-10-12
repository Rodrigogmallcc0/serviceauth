# Utiliza una imagen base de Java 17
FROM adoptopenjdk/openjdk17:jre

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR generado por Maven a la imagen
COPY target/serviceauth-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (o el puerto que estés utilizando en tu aplicación Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
