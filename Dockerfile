FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

EXPOSE 8081

ENTRYPOINT ["java","-javaagent:/app/opentelemetry-javaagent.jar","-Dotel.exporter.otlp.endpoint=http://otel-collector:4317","-Dotel.exporter.otlp.protocol=grpc","-Dotel.metrics.exporter=otlp","-Dotel.logs.exporter=otlp","-Dotel.service.name=product-service","-jar", "app.jar"]