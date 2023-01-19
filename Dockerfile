FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} klx-test-test.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/klx-test-test.jar"]