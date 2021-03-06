CREATE TABLE IF NOT EXISTS booking_log (
id SERIAL PRIMARY KEY,
email varchar(255) NOT NULL,
movie_show_id INT REFERENCES movie_shows(id) NOT NULL,
no_of_tickets INT NOT NULL,
date_of_booking TIMESTAMP NOT NULL
);

ALTER TABLE movie_shows ADD COLUMN booked_seats INT NOT NULL DEFAULT 0;

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-01 09:15:00', '2019-02-01 11:15:00', 200);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-01 14:15:00', '2019-02-01 16:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-01 19:15:00', '2019-02-01 21:15:00', 397);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-02 09:15:00', '2019-02-02 11:15:00', 200);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-02 14:15:00', '2019-02-02 16:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-02 19:15:00', '2019-02-02 21:15:00', 397);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-02 22:15:00', '2019-02-02 23:55:00', 397);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-04 09:15:00', '2019-02-04 11:15:00', 200);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-04 14:15:00', '2019-02-04 16:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-04 19:15:00', '2019-02-04 21:15:00', 397);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (1, 2, 2, '2019-02-04 22:15:00', '2019-02-04 23:55:00', 397);


INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-01 09:15:00', '2019-02-01 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-01 14:15:00', '2019-02-01 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-01 19:15:00', '2019-02-01 21:15:00', 100);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-02 09:15:00', '2019-02-02 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-02 14:15:00', '2019-02-02 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-02 19:15:00', '2019-02-02 21:15:00', 100);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-03 09:15:00', '2019-02-03 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-03 14:15:00', '2019-02-03 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-03 19:15:00', '2019-02-03 21:15:00', 100);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-04 09:15:00', '2019-02-04 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-04 14:15:00', '2019-02-04 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-04 19:15:00', '2019-02-04 21:15:00', 100);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-05 09:15:00', '2019-02-05 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-05 14:15:00', '2019-02-05 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-05 19:15:00', '2019-02-05 21:15:00', 100);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-06 09:15:00', '2019-02-06 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-06 14:15:00', '2019-02-06 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-06 19:15:00', '2019-02-06 21:15:00', 100);

INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 2, 2, '2019-02-07 09:15:00', '2019-02-07 11:15:00', 400);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 1, 3, '2019-02-07 14:15:00', '2019-02-07 16:15:00', 498);
INSERT INTO MOVIE_SHOWS (MOVIE_ID, THEATER_ID, SOUND_SYSTEM_ID, START_TIME, END_TIME, BOOKED_SEATS) VALUES (3, 3, 1, '2019-02-07 19:15:00', '2019-02-07 21:15:00', 100);