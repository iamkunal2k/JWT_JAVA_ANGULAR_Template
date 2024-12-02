-- Add role field to users table
ALTER TABLE users
ADD COLUMN role VARCHAR(10) NOT NULL DEFAULT 'USER';

-- Add profile_pic and is_online fields
ALTER TABLE users
ADD COLUMN is_online BOOLEAN DEFAULT FALSE;

-- Create a CHECK constraint for role
ALTER TABLE users
ADD CONSTRAINT chk_user_role CHECK (role IN ('USER', 'ADMIN'));
