FROM eclipse-temurin:17-jdk-jammy

LABEL authors="Ramakant rawat"

COPY src/ src/
COPY pom.xml .

RUN mvn clean package -Dmaven.test.skip=true

RUN apk update \
    && apk add curl
RUN apk add --update tzdata

ENV TZ="Asia/Singapore"

COPY --from=builder target/poc-0.0.1-SNAPSHOT.jar poc-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","-Xmx2g", "poc-0.0.1-SNAPSHOT.jar"]