FROM openjdk:18-jdk-alpine3.15
ADD build/libs/nbp-api-spring-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar nbp-api-spring-0.0.1-SNAPSHOT.jar --envname=prod