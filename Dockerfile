FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# copy only jar (not full project)
COPY target/*.jar app.jar

EXPOSE 8080
CMD ["java","-jar","app.jar"]