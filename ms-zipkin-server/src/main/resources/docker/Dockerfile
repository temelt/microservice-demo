FROM java:8
VOLUME /tmp
ADD *.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 62503
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]