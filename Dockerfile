#
# Build stage
#
FROM maven:3.8-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-alpine
COPY --from=build /home/app/target/gracie-0.1.jar /usr/local/lib/gracie-manager.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/gracie-manager.jar"]
