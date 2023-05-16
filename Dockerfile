FROM amazoncorretto:17

LABEL  MAINTAINER TomasNieto

COPY portfolio.jar portfolio.jar

ENTRYPOINT ["java","-jar","/portfolio.jar"]