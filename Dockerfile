# Etapa de construcción
FROM openjdk:17-jdk-slim AS builder

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el código fuente de la aplicación (si usas Maven o Gradle, copia el archivo pom.xml o build.gradle primero y luego el código fuente)
COPY . /app

# Compilar la aplicación (asume que estás usando Maven o Gradle)
RUN ./mvnw clean package -DskipTests

# Etapa de runtime
FROM openjdk:17-jdk-slim

# Directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=builder /app/target/mi-app.jar /app/mi-app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/mi-app.jar"]
