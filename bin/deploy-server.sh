#!/bin/bash
source env.sh $1;

echo "build server:${BLOG_ENV}";

cd ${SERVER_DIR};
mvn clean package -Dmaven.test.skip=true -Denv=${BLOG_ENV};

if [ "production" == "$BLOG_ENV" ]; then
  ;
fi
if [ "uat" == "$BLOG_ENV" ]; then
  ;
fi
if [ "local" == "$BLOG_ENV" ]; then
  catalina.sh stop;
  sleep 5;
  rm -rf ${LOCAL_TOMCAT_BASE}/webapps/ROOT*
  rm /tmp/blog_server.log
  cp ${SERVER_DIR}/target/blog-server.war ${LOCAL_TOMCAT_BASE}/webapps/ROOT.war
  catalina.sh start;
fi
