#!/bin/bash

source env.sh $1;

cd ${BIN_DIR};
# sql
if [ "local" == "$BLOG_ENV" ]; then
  cd ${SQL_DIR}/bin;
  source deploy-sql.sh;
fi

cd ${BIN_DIR};
# server
source ./deploy-server.sh $1;

cd ${BIN_DIR};
# front
source ./deploy-front.sh $1;
