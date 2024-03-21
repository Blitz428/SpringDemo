CREATE TABLE IF NOT EXISTS Content(
    id SERIAL PRIMARY KEY,
    title varchar(255) not null,
    description text,
    status varchar(20) not null,
    content_type varchar(50) not null,
    date_created timestamp not null,
    date_updated timestamp,
    url varchar(255),
    progress decimal,
    deadline timestamp
);

CREATE TABLE IF NOT EXISTS "Users"(
    id serial PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(255),
    email VARCHAR(255),
    address JSONB,
    phone VARCHAR(30),
    website VARCHAR(255),
    company JSONB
);

CREATE TABLE IF NOT EXISTS "company"(
    users decimal,
    bs VARCHAR(255),
    catch_phrase VARCHAR(255),
    name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS "address"(
    users decimal,
    city VARCHAR(255),
    street VARCHAR(255),
    suite VARCHAR(255),
    zipcode VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS "geo"(
    users decimal,
    lat VARCHAR(255),
    lng VARCHAR(255)
    );