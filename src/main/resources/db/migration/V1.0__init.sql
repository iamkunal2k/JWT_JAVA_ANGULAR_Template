--CREATE TYPE role AS ENUM ('USER', 'ADMIN');
--CREATE TYPE message_type AS ENUM ('CHAT', 'JOIN', 'LEAVE');
--
--CREATE TABLE users (
--    id SERIAL PRIMARY KEY,
--    username VARCHAR(50) UNIQUE NOT NULL,
--    password VARCHAR(255) NOT NULL,
--    role role NOT NULL,
--    is_online BOOLEAN DEFAULT FALSE
--);
--
--CREATE TABLE chat_messages (
--    id SERIAL PRIMARY KEY,
--    sender_id INT REFERENCES users(id),
--    content BYTEA NOT NULL,
--    type message_type NOT NULL,
--    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--);
--
--CREATE TABLE friendships (
--    id SERIAL PRIMARY KEY,
--    user_id INT REFERENCES users(id),
--    friend_id INT REFERENCES users(id),
--    status VARCHAR(20) DEFAULT 'PENDING'
--);


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL)