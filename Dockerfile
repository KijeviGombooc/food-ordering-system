# Use dev docker image as base
FROM java17-openjdk-maven

COPY src ./src
COPY pom.xml .

RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-jar", "/target/foodorderingsystem-0.0.1-SNAPSHOT.jar"]