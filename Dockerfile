# Use official OpenJDK 21 image
FROM eclipse-temurin:21

# Set working directory
WORKDIR /app

# Copy built jar into container
COPY build/libs/idtech-ms-orders-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 9898

# Run the jar
CMD ["java", "-jar", "app.jar"]

#docker build -t my-app .#./gradlew clean build
#docker rename reverent_volhard java-spring-mg
#docker rm -f reverent_volhard
#docker build -t java-spring-mg . create image