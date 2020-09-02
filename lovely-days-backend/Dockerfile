#### Stage 1: 构建 app
#FROM openjdk:11 as build
#MAINTAINER Xiaoshi wangxiaoshicc@gmail.com
#WORKDIR /app
#
## Copy maven executable to the image
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#
## Build all the dependencies in preparation to go offline.
## This is a separate step so the dependencies will be cached unless
## the pom.xml file has changed.
#RUN chmod +x mvnw
#RUN ./mvnw dependency:go-offline -B
#
## Copy the project source
#COPY src src
#
### Package the application
#RUN ./mvnw package -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
#
#### Stage 2: A minimal docker image with command to run the app
#FROM openjdk:11
#
#
#ARG DEPENDENCY=/app/target/dependency
#
## Copy project dependencies from the build stage
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#
#RUN ls -a
## 最后一个参数是主类 main class 的路径
##ENTRYPOINT ["java","-cp","app:app/lib/*","xyz.wangxiaoshi.lovelydaysbackend.LovelyDaysBackendApplication.class"]
#ENTRYPOINT ["java", "-jar", "app/target/lovely-days-backend-0.0.1-SNAPSHOT.jar"]

### BUILD image
FROM maven:3-jdk-11 as builder
#Copy Custom Maven settings
#COPY settings.xml /root/.m2/
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#RUN mvn dependency:resolve-plugins
#Copy source code
COPY src /build/src
# Build application
RUN mvn package -DskipTests


FROM openjdk:11-slim as runtime
EXPOSE 8080
#Set app home folder
ENV APP_HOME /app
#Possibility to set JVM options (https://www.oracle.com/technetwork/java/javase/tech/vmoptions-jsp-140102.html)
ENV JAVA_OPTS=""

#Create base app folder
RUN mkdir $APP_HOME
#Create folder to save configuration files
RUN mkdir $APP_HOME/config
#Create folder with application logs
RUN mkdir $APP_HOME/log

VOLUME $APP_HOME/log
VOLUME $APP_HOME/config

WORKDIR $APP_HOME
#Copy executable jar file from the builder image
COPY --from=builder /build/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]
#Second option using shell form:
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar $0 $@
