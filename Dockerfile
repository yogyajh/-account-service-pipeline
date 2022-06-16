FROM openjdk:8
EXPOSE 8080
ADD target/account-service-pipeline.jar account-service-pipeline.jar
ENTRYPOINT ["java","-jar","/account-service-pipeline.jar"]