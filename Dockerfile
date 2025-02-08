# Base Image (빌드용) - JDK 21 지원
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Gradle Wrapper 사용하여 빌드
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

# Runtime Image - JDK 21 사용
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]



