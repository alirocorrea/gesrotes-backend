FROM maven:3.6.1-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11
VOLUME /tmp
COPY --from=build /home/app/target/gesrotes-0.0.1.jar gesrotes-backend-server.jar
ENV TZ="America/Bogota"
ENTRYPOINT ["java","-jar","/gesrotes-backend-server.jar"]
