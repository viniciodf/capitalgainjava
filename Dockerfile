FROM openjdk:13-slim
EXPOSE 8080
ADD /target/capitalgainjava-1.0-SNAPSHOT.jar capitalgainjava-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","capitalgainjava-1.0-SNAPSHOT.jar"]