# Pull base image.
FROM openjdk:8-jdk-alpine

#COPY search-api-0.0.1-SNAPSHOT.jar /j.war
#WORKDIR /tmp
#CMD ["/usr/bin/java", "-jar", "/app.war"]
EXPOSE 8081

VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/live/./urandom","-Dspring.profiles.active=live","-jar","/app.jar"]

