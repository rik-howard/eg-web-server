FROM openjdk:17-jdk-slim
ARG VERSION
COPY tmp/web-server-application-$VERSION.jar /home
EXPOSE 8084
ENV VERSION=$VERSION
ENV COLOUR=yellow
ENV SERVER_PORT=8083
ENTRYPOINT java -jar /home/web-server-application-$VERSION.jar
