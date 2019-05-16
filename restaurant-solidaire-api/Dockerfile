FROM openjdk:8u151-jre-alpine

WORKDIR /etc/code-solidaire

COPY target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

