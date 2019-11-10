FROM isortegah/java8:v1


EXPOSE 8080

#Docker
#RUN mkdir -p /root/.aws
#ADD credentials /root/.aws/credentials

#Heroku
RUN mkdir -p /app/.aws
ADD credentials /app/.aws/credentials

RUN mkdir -p /app
WORKDIR /app

ADD bootstrap.sh bootstrap.sh
ADD rest/target/rest-0.2.0-SNAPSHOT.jar rest.jar
ADD config.yml config.yml

CMD ["/bin/bash", "./bootstrap.sh"]