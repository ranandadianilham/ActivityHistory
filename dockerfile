FROM openjdk:8-jdk-alpine

COPY ActivityHistory-0.0.1.jar ActivityHistory.jar

EXPOSE 8809

ENTRYPOINT ["java","-jar","ActivityHistory.jar"]
