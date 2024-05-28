create table tasks (
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       description VARCHAR(512) NOT NULL,
                       status enum('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED'),
                       created_at datetime
);