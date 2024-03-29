FROM maven:3.8.6-openjdk-18-slim AS build
COPY . .
RUN mvn clean package -Pprod

FROM openjdk:18-slim AS spring-app
COPY --from=build /target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]
