# 1. Usamos la imagen oficial de Eclipse Temurin para Java 25
FROM eclipse-temurin:25-jdk

# 2. Creamos una carpeta de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiamos el archivo JAR compilado hacia adentro del contenedor
# (Asegúrate de que el nombre coincida con el que se generó en tu carpeta target)
COPY target/apidemo-0.0.1-SNAPSHOT.jar app.jar

# 4. Le decimos a Docker que nuestra app va a usar el puerto 8080
EXPOSE 8080

# 5. El comando de arranque que se ejecutará al encender el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]