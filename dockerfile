FROM openjdk:8-jdk-alpine

ADD ActivityHistory-0.0.1.jar ActivityHistory.jar

EXPOSE 8809

ENTRYPOINT ["java","-jar","ActivityHistory.jar"]