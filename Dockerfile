FROM maven:3.8.7-openjdk-18-slim AS build
COPY . .
RUN mvn clean install -Pprod

FROM openjdk:18-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]