CREATE TABLE testing_entity (
	user_id serial PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL
);