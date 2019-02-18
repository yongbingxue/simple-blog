#!/bin/bash
source env.sh $1;

echo "build front:${BLOG_ENV}";

cd ${FRONT_DIR};

ng serve;
