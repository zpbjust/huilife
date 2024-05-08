CREATE DATABASE huilife
    ENCODING = 'UTF-8'
    LC_COLLATE = 'en_US.UTF-8'
    TEMPLATE template0;
DROP ROLE IF EXISTS huilife;
CREATE ROLE huilife WITH LOGIN password 'huilife';
GRANT ALL ON DATABASE huilife TO huilife;