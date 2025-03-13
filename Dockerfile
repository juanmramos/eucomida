FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/eucomida-api.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
