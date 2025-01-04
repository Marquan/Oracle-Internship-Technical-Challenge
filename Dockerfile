FROM maven:3.6.3-jdk-8 as part-1
COPY spring-boot-hello-world-main /app
WORKDIR /app
RUN ls
RUN mvn clean install -DskipTests

FROM openjdk:8-jdk-alpine
RUN mkdir -p /app/jars
COPY --from=part-1 /app/target/spring-boot-2-hello-world*.jar /app/jars
COPY --from=part-1 /app/src/main/resources/application.properties /app/jars
WORKDIR /app/jars

EXPOSE 8080
ENTRYPOINT java -jar spring-boot-2-hello-world*.jar