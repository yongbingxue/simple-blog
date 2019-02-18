#!/bin/bash

if [ "production" == "$1" ]; then
  BLOG_ENV=production;
elif [ "uat" == "$1" ]; then
  BLOG_ENV=uat;
elif [ "local" == "$1" ]; then
  BLOG_ENV=local;
else
  BLOG_ENV=local;
fi
echo "running env:"$BLOG_ENV;

CUR_DIR=`pwd`;
echo CUR_DIR:${CUR_DIR};


BASE_DIR=$(echo ${CUR_DIR%%blog*})blog;
echo BASE_DIR:${BASE_DIR};

BIN_DIR=${BASE_DIR}/bin
echo BIN_DIR:${BIN_DIR};

SERVER_DIR=${BASE_DIR}/blog-server;
echo SERVER_DIR:${SERVER_DIR};

FRONT_DIR=${BASE_DIR}/blog-front;
echo FRONT_DIR:${FRONT_DIR};

SQL_DIR=${BASE_DIR}/blog-sql;
echo SQL_DIR:${SQL_DIR};


#########
LOCAL_TOMCAT_BASE=/usr/local/tomcat;
echo LOCAL_TOMCAT_BASE:${LOCAL_TOMCAT_BASE};
