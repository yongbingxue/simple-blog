/*DROP USER IF EXISTS 'blog'@'localhost';*/

/*CREATE USER 'blog'@'localhost' IDENTIFIED BY 'blog';*/

DROP DATABASE IF EXISTS blog;

CREATE DATABASE blog DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

GRANT ALL ON blog.* TO 'blog'@'localhost' IDENTIFIED BY 'blog';
