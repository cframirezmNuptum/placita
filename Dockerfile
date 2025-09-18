# Etapa de build
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

# Etapa de runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia el jar generado (cualquiera que sea el nombre)
COPY --from=build /workspace/target/*.jar /app/app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
