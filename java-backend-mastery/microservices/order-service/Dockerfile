FROM eclipse-temurin:26-jre-alpine
WORKDIR /app
COPY target/order-service-*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "app.jar"]
