CREATE DATABASE ssh
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE ssh;
CREATE TABLE users
(
	id VARCHAR(32) NOT NULL,`ssh`
	NAME VARCHAR(20),
	PASSWORD VARCHAR(20)
);
ALTER TABLE users
	ADD CONSTRAINT users_pk PRIMARY KEY(id);
INSERT INTO users VALUES('1','admin','1234');`ssh`