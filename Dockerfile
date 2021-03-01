FROM openjdk:latest
COPY ./target/group-h-sem-0.1.0.4-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group-h-sem-0.1.0.4-jar-with-dependencies.jar"]