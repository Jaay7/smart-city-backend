FROM openjdk:11

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

CMD ["./gradlew", "bootRun"]
