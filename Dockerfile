FROM amazoncorretto:11-alpine-jdk
RUN apk --no-cache add curl
VOLUME /tmp
ARG REGION_ARG=us-east-1
ARG ACCESS_ARG
ARG SECRET_ARG
ENV AWS_REGION=$REGION_ARG
ENV AWS_ACCESS_KEY=$ACCESS_ARG
ENV AWS_SECRET_KEY=$SECRET_ARG
ARG JAR_FILE=build/libs/\*.jar
COPY ${JAR_FILE} app.jar/
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
