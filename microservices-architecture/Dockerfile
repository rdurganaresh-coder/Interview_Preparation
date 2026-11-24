FROM eclipse-temurin:17-jre-alpine
ARG MODULE_NAME
WORKDIR /app
COPY ${MODULE_NAME}/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
