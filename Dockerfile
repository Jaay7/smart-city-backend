FROM openjdk:11

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

# ARG JAR_FILE=build/libs/smartcitybackend-0.0.1-SNAPSHOT.jar

COPY build/libs/*.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "smartcitybackend-0.0.1-SNAPSHOT.jar"]
