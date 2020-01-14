# Pull base image.
FROM debian:latest

#COPY search-api-0.0.1-SNAPSHOT.jar /j.war
#WORKDIR /tmp
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=dev", "/app.war"]
EXPOSE 8080

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

