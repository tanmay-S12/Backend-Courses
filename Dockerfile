FROM openjdk:17
# Copy the JAR file into the container
COPY target/courses_backend-0.0.1-SNAPSHOT.jar coursesbackend.jar
# Expose the port your application runs on
EXPOSE 8080
# Run the JAR file
ENTRYPOINT ["java", "-jar", "coursesbackend.jar"]