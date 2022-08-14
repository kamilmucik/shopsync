FROM adoptopenjdk/openjdk11

COPY "application.yml" "/application.yml"
COPY "target/web-app-0.0.5-SNAPSHOT.jar" "/app.jar"

EXPOSE 8088 8000
CMD ["-jar", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000", "/app.jar" ]
ENTRYPOINT [ "java" ]
