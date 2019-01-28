CREATE TABLE MOVIE (
	id SERIAL PRIMARY KEY,
	name varchar(255) NOT NULL,
	certification varchar(10) NOT NULL,
	language varchar(255) NOT NULL,
	synopsis varchar(255) NOT NULL,
	genre varchar(255) NOT NULL,
	crew varchar(255) NOT NULL,
	movie_cast varchar(255) NOT NULL,
	runtime integer NOT NULL,
	experiences varchar(255) NOT NULL,
	listing_type varchar(20) NULL
);