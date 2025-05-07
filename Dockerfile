# 1) Build stage usando JDK 21 e Maven Wrapper
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiamos apenas o wrapper + pom + código-fonte
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Damos permissão de execução ao wrapper e empacotamos
RUN chmod +x mvnw \
 && ./mvnw clean package -DskipTests -B

# 2) Run stage com JRE 21
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiamos o JAR gerado
COPY --from=build /app/target/moneo-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
EXPOSE 5005   

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","app.jar"]

