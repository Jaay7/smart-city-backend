FROM openjdk:11

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

ARG JAR_FILE=build/libs/smartcitybackend-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar/

CMD ["java", "-jar", "/app.jar"]
