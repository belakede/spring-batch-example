CREATE TABLE candidates  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    full_name VARCHAR(100),
    age INTEGER,
    town VARCHAR(100),
    job_title VARCHAR(100)
);