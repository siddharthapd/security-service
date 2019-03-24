# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
MAINTAINER siddharthap <sid.cse2013@gmail.com>

VOLUME /opt/javadev/logs
COPY /target/security-service-1.0-SNAPSHOT.jar /opt/security-service-1.0-SNAPSHOT.jar
COPY security-service-entrypoint.sh /opt/security-service-entrypoint.sh
RUN chmod 755 /opt/security-service-entrypoint.sh
EXPOSE 18083
