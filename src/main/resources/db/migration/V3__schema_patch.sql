CREATE TABLE locations (
id SERIAL PRIMARY KEY,
name VARCHAR UNIQUE
);

CREATE TABLE theaters (
id SERIAL PRIMARY KEY,
name VARCHAR NOT NULL,
location_id INT REFERENCES locations(id) NOT NULL,
capacity INT NOT NULL DEFAULT 0
);


CREATE TABLE sound_systems (
id SERIAL PRIMARY KEY,
type VARCHAR NOT NULL
);

CREATE TABLE movie_shows (
id SERIAL PRIMARY KEY,
movie_id INT REFERENCES movie(id) NOT NULL,
theater_id INT REFERENCES theaters(id) NOT NULL,
sound_system_id INT REFERENCES sound_systems(id) NOT NULL,
start_time TIMESTAMP NOT NULL,
end_time TIMESTAMP NOT NULL
);


