# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="siapakahgw@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8084

# The application's jar file

# Add the application's jar to the container
ADD  /target/apiCoreHias-0.0.1-SNAPSHOT.jar apiCoreHias.jar

# Run the jar file
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","apiCoreHias.jar"]