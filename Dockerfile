FROM openjdk:latest
COPY ./target/groupHSemMethods.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "groupHSemMethods.jar", "db:3306"]

