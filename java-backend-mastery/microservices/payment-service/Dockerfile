FROM eclipse-temurin:26-jre-alpine
WORKDIR /app
COPY target/payment-service-*.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "app.jar"]
