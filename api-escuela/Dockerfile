FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/api-escuela-0.0.1.jar
COPY ${JAR_FILE} api-escuela.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-escuela.jar"]