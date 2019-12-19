# Pull base image.
FROM debian:latest

COPY search-api-0.0.1-SNAPSHOT.jar /j.war
WORKDIR /tmp
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=dev", "/app.war"]
EXPOSE 8080




