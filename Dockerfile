FROM isortegah/java8:v1


EXPOSE 8080

RUN mkdir -p /root/.aws
ADD credentials /root/.aws/credentials

RUN mkdir -p /app
WORKDIR /app

ADD bootstrap.sh bootstrap.sh
ADD rest/target/rest-0.1-SNAPSHOT.jar rest.jar
ADD config.yml config.yml

CMD ["/bin/bash", "./bootstrap.sh"]