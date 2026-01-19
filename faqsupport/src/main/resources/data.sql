-- src/main/resources/data.sql

-- Insert roles if they don't exist
INSERT OR IGNORE INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT OR IGNORE INTO roles (name) VALUES ('ROLE_USER');

-- Insert a test user with a BCrypt encoded password
-- The password for 'adminuser' is 'password123'
-- Note: Replace with your own test user and a securely generated BCrypt hash
INSERT OR IGNORE INTO users (username, password, enabled) VALUES ('adminuser', '$2a$10$wOaR.qA4694N2.gA9Z.nKeJkS2rZ.6nB7g.s1H.j8G.gO.W.dK.t.E', 1);

-- Assign the ADMIN role to the test user
-- You will need to look up the ID of the 'adminuser' and 'ROLE_ADMIN'
INSERT OR IGNORE INTO users_roles (user_id, role_id) VALUES (
    (SELECT id FROM users WHERE username = 'adminuser'),
    (SELECT id FROM roles WHERE name = 'ROLE_ADMIN')
);
