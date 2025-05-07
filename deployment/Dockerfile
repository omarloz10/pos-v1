FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY .env.docker .env
COPY applications/app-service/build/libs/pos-v1.jar pos-v1.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
#USER appuser
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar pos-v1.jar" ]
