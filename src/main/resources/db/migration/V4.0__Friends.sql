CREATE TABLE friends (
    user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    friend_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    status VARCHAR(10) NOT NULL CHECK (status IN ('PENDING', 'ACCEPTED', 'REJECTED')),
    PRIMARY KEY (user_id, friend_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_friend FOREIGN KEY (friend_id) REFERENCES users(id) ON DELETE CASCADE
);
