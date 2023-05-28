FROM amazoncorretto:11-alpine-jdk
RUN apk --no-cache add curl
VOLUME /tmp
RUN pwd
RUN mkdir -p build/libs
ARG JAR_FILE=./build/libs/\*.jar
COPY ${JAR_FILE} app.jar/
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
