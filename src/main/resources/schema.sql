-- User Table
CREATE TABLE users (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       active bool DEFAULT FALSE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);

-- Message Table
CREATE TABLE messages (
                          message_id INT PRIMARY KEY AUTO_INCREMENT,
                          sender_id INT,
                          receiver_id INT,
                          text TEXT,
                          sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          read_at TIMESTAMP,
                          FOREIGN KEY (sender_id) REFERENCES users(user_id),
                          FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);
