-- tables
-- Table: resources
CREATE TABLE resources (
                           id int  NOT NULL,
                           name varchar(20)  NOT NULL,
                           content varchar(100)  NOT NULL,
                           CONSTRAINT resources_pk PRIMARY KEY (id)
);

-- Table: users
CREATE TABLE users (
                       id int  NOT NULL,
                       username varchar(30)  NOT NULL,
                       password varchar(20)  NOT NULL,
                       CONSTRAINT users_pk PRIMARY KEY (id)
);

-- Table: users_resources
CREATE TABLE users_resources (
                                 users_id int  NOT NULL,
                                 resources_id int  NOT NULL
);

-- foreign keys
-- Reference: users_resources_resources (table: users_resources)
ALTER TABLE users_resources ADD CONSTRAINT users_resources_resources
    FOREIGN KEY (resources_id)
        REFERENCES resources (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: users_resources_users (table: users_resources)
ALTER TABLE users_resources ADD CONSTRAINT users_resources_users
    FOREIGN KEY (users_id)
        REFERENCES users (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.
