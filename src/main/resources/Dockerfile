FROM eclipse-temurin:19-jre-jammy
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "app.jar"]