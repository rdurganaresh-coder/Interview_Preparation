FROM eclipse-temurin:26-jre-alpine
WORKDIR /app
COPY target/service-discovery-*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
