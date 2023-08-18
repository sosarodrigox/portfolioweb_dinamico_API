FROM amazoncorretto:11-alpine-jdk
MAINTAINER sosarodrigo
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolioweb-app.jar
ENTRYPOINT ["java", "-jar", "/portfolioweb-app.jar"]