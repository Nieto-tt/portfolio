FROM amazoncorretto:17-alpine-jdk

MAINTAINER TomasNieto

COPY portfolio.jar portfolio.jar

ENTRYPOINT ["java","-jar","/portfolio.jar"]