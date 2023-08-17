FROM openjdk:17-oracle
EXPOSE 8183
ARG JAR_FILE=*.jar
COPY ssl /etc/ssl
COPY ${JAR_FILE} generator.jar
ENTRYPOINT ["java", "-jar", "/generator.jar"]

#docker tag test:latest <repo>/<user>/test:latest
#docker push <repo>/<user>/test:latest
#
#docker tag test:0.2 <repo>/<user>/test:0.2
#docker push <repo>/<user>/test:0.2
#
#docker build -t python:latest -t python:3.6 -t python:3.4
#
#docker tag user/imagename:tag1
#docker tag user/imagename:tag2
#docker push user/imagename
#
#docker build -t baeldung-java:5 -t baeldung-java:6 .
