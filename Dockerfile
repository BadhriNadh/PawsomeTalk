FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

FROM openjdk:17

WORKDIR /deploy

COPY --from=build /app/target/chat-0.0.1.jar /deploy/chat.jar

EXPOSE 8080

CMD ["java", "-jar", "chat.jar"]

LABEL version="0.0.1"
LABEL maintainer="Badhri Nadh Arja <arja.badhrinadh@gmail.com>"
LABEL description="Group-dots"
