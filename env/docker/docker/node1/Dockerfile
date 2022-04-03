FROM adoptopenjdk/openjdk11

COPY "application.yml" "/application.yml"
COPY "target/web-app.jar" "/app.jar"

EXPOSE 8088
CMD [ "-jar", "/app.jar" ]
ENTRYPOINT [ "java" ]
