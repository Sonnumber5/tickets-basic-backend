-- DDL for user and ticket tables (H2 in-memory for base milestone)
CREATE TABLE IF NOT EXISTS users (
  user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(200) NOT NULL,
  roles VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS tickets (
  ticket_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  priority VARCHAR(16) NOT NULL,
  due_date DATE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
