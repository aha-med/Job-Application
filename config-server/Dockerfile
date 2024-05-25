FROM openjdk:17-oracle
LABEL maintainer="ahamed"
ADD target/config-server-0.0.1-SNAPSHOT.jar config-server
ENTRYPOINT ["java","-jar","config-server"]