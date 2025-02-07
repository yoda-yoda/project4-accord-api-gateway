FROM gradle:8.1.1-jdk21 AS builder
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

RUN ./gradlew --no-daemon dependencies

COPY . .

RUN ./gradlew bootJar --no-daemon -x test

FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8082

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
