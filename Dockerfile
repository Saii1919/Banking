#Start with base image
FROM openjdk:17-jdk

COPY target/BankProject-0.0.1-SNAPSHOT.jar BankProject-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","BankProject-0.0.1-SNAPSHOT.jarm"]
