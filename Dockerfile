FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY target/keycloak-*.jar keycloak-demo-service.jar
EXPOSE 8082
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -Dspring.profiles.active=docker -jar keycloak-demo-service.jar
