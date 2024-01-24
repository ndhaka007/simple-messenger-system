# Stage 1 (Build Stage)
FROM gradle:jdk21 AS builder

WORKDIR /home/gradle/src

# Copy only the necessary files for Gradle dependencies resolution
COPY build.gradle settings.gradle gradlew /home/gradle/src/
COPY gradle /home/gradle/src/gradle

# Copy the source code
COPY src /home/gradle/src/src

# Resolve dependencies and build the project
RUN echo "building project"
RUN gradle clean build

# Stage 2 (Final Stage)
FROM openjdk:21

# Copy the JAR file from the build stage
COPY --from=builder /home/gradle/src/build/libs/* /app/app.jar

# Set the working directory
WORKDIR /app

# Expose the port your application runs on
EXPOSE 8080

ENTRYPOINT  ["java","-Dspring.profiles.active=dev_docker","-Dlog4j2.formatMsgNoLookups=true","-jar","/app/app.jar"]