# From Base image OpenJDK
FROM openjdk:8.
# Copy the war from src to dest.
ADD target/docker.spring-0.0.1-SNAPSHOT.war docker.spring-0.0.1-SNAPSHOT.war
# Create data folder for bind mount
RUN mkdir -p ./Docker/Data/db
# First command to be executed.
CMD ["java", "-jar", "docker.spring-0.0.1-SNAPSHOT.war"]