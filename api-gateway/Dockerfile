FROM openjdk:21-jdk-slim
COPY target/api-gateway-1.0.0.jar notification-service.jar
ENTRYPOINT ["java","-jar","/notification-service.jar"]