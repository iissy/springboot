FROM java:8
VOLUME /tmp
ADD springboot.jar /springboot.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot.jar"]