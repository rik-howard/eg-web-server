FROM openjdk:17-jdk-slim
COPY tmp/web-server-application-0.2.0.jar /home
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/home/web-server-application-0.2.0.jar"]
