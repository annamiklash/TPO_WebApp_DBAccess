-- foreign keys
ALTER TABLE users_resources
    DROP CONSTRAINT users_resources_resources;

ALTER TABLE users_resources
    DROP CONSTRAINT users_resources_users;

-- tables
DROP TABLE resources;

DROP TABLE users;

DROP TABLE users_resources;

-- End of file.

