FROM openjdk:17-jdk-slim
EXPOSE 8183
ARG JAR_FILE=*.jar
COPY ssl /etc/ssl
COPY ${JAR_FILE} generator.jar
ENTRYPOINT ["java", "-jar", "/generator.jar"]
