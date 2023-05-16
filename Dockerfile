FROM amazoncorretto:11

MAINTAINER tunombre_o_alias

COPY target/NAME-YOUR-FILE-BUILD-SPRINGBOOT.jar NAME-YOUR-FILE-BUILD-SPRINGBOOT.jar

ENTRYPOINT ["java","-jar","/portfolio.jar"]