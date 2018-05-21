FROM java:8
EXPOSE 8080
ADD /target/learn-security-*.jar learn-security.jar
ENTRYPOINT ["java","-jar","learn-security.jar"]
