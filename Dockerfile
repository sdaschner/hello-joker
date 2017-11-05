FROM tomee:8-jre-7.0.3-plus

COPY target/hello-joker.war /usr/local/tomee/webapps/
