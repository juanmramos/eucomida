FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/eucomida-0.0.1-SNAPSHOT.jar /app/eucomida-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
