FROM openjdk:11-jdk
ARG JAR_FILE=./build/libs/toilet-0.0.1-SNAPSHOT.jar
ENV ENV_IDLE_PROFILE=$IDLE_PROFILE
COPY ${JAR_FILE} app.jar
RUN echo $ENV_IDLE_PROFILE
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=${ENV_IDLE_PROFILE}"]