# Basimage med Java 17
FROM eclipse-temurin:17-jdk

# Ange arbetsmapp i containern
WORKDIR /app

# Kopiera din byggda Spring Boot jar till containern
COPY build/libs/WebService_Uppgifter_Lektion_5-0.0.1-SNAPSHOT.jar /app/my-spring-app.jar

# Exponera samma port som Spring Boot använder
EXPOSE 8080

# Starta applikationen
ENTRYPOINT ["java", "-jar", "/app/my-spring-app.jar"]