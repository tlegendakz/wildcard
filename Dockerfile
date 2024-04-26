FROM docker.io/eclipse-temurin:17-jdk-alpine
ENV TZ=Asia/Yekaterinburg
WORKDIR /workspace/app
COPY target/wildcard-1.0.0.jar /workspace/app/wildcard-1.0.0.jar
EXPOSE 8072/tcp
CMD ["java", "-jar", "-Dspring.profiles.active=prom", "wildcard-1.0.0.jar"]
