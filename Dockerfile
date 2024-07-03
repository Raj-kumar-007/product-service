
# java runtime
FROM amazoncorretto

# working directory
WORKDIR app

# copy the jar of springboot application into the directory
COPY ./build/libs/*.jar app/app.jar

# export the port to run the application
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
