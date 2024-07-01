FROM openjdk:17-jdk-slim
ARG VERSION
COPY tmp/web-server-application-$VERSION.jar /home
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/web-server-application-0.2.0.jar"]
CMD ["--colour=blue"]
