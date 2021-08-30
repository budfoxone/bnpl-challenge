FROM openjdk:11

COPY target/challenge*spring-boot.jar app.jar

CMD java \
    -Duser.timezone=Pacific/Auckland \
    -jar /app.jar
