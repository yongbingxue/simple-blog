#!/bin/bash

mysql --user=root --password=root < ../database/database.sql;
mysql --user=root --password=root < ../database/function.sql;

# complete
java -jar lib/liquibase.jar                 \
      --driver=com.mysql.jdbc.Driver          \
      --classpath=lib/mysql-connector-java-5.1.44.jar                \
      --changeLogFile=../complete/runscript.xml                \
      --url="jdbc:mysql://localhost:3306/blog?useUnicode=yes&characterEncoding=UTF-8&useSSL=false"                \
      --username=blog                \
      --password=blog                \
      update

mysql --user=blog --password=blog --database=blog < ../data/101_Category.sql;
mysql --user=blog --password=blog --database=blog < ../data/102_Book.sql;
mysql --user=blog --password=blog --database=blog < ../data/103_Chapter.sql;
