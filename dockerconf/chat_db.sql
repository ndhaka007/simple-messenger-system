CREATE DATABASE IF NOT EXISTS chat;

DROP USER IF EXISTS 'chat_user'@'%';
FLUSH PRIVILEGES;
CREATE USER 'chat_user'@'%' identified by '123';
GRANT ALL PRIVILEGES ON chat.* TO 'chat_user'@'%';