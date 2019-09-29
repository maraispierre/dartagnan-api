FROM openjdk:8

COPY /build/libs/darts-api-0.0.1-SNAPSHOT.jar /app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]