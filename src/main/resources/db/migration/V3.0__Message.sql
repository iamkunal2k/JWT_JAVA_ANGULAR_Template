CREATE TABLE messages (
    id SERIAL PRIMARY KEY,                         -- Unique identifier for each message
    content TEXT NOT NULL,                         -- The message content
    type VARCHAR(10) NOT NULL CHECK (type IN ('CHAT', 'JOIN', 'LEAVE')), -- Enum for message type
    sender_id INT NOT NULL REFERENCES users(id),   -- Foreign key to users table for sender
    timestamp TIMESTAMP DEFAULT NOW()              -- Timestamp of message creation
);
