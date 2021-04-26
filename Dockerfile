FROM openjdk:latest
COPY ./target/groupHSemMethods.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "groupHSemMethods.jar", "database:3306"]