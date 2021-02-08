FROM openjdk:latest
COPY ./target/classes/com /tmp/com
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group-h-sem-0.1.0.2-jar-with-dependencies.jar"]


