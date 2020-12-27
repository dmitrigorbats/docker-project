FROM openjdk:14-alpine
VOLUME /tmp
EXPOSE 8080
ADD build/libs/docker-project-0.0.1-SNAPSHOT.jar docker-project.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker-project.jar"]