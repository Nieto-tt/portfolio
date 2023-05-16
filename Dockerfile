FROM amazoncorretto:11

LABEL  MAINTAINER TomasNieto

COPY target/portfolio.jar portfolio.jar

ENTRYPOINT ["java","-jar","/portfolio.jar"]