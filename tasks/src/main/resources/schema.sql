CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       description VARCHAR(512) NOT NULL,
                       status VARCHAR(20) NOT NULL CHECK (status IN ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED')),
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);