FROM eclipse-temurin:19
RUN mkdir /opt/app
COPY target/demo-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]
