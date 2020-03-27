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

### Stage 1 : build with maven builder image with native capabilities
#FROM quay.io/quarkus/centos-quarkus-maven:19.3.1-java8 AS build
#COPY pom.xml /usr/src/app
#COPY src /usr/src/app/src
#USER root
#RUN chown -R quarkus /usr/src/app
#USER quarkus
#RUN mvn -f /usr/src/app/pom.xml -Pnative clean package
#
### Stage 2 : create the docker final image
#FROM registry.access.redhat.com/ubi8/ubi-minimal
#WORKDIR /work/
#COPY --from=build /usr/src/app/target/*-runner /work/application
#RUN chmod 775 /work
#EXPOSE 8080
#CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]