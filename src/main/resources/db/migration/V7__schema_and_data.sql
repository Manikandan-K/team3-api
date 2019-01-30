ALTER TABLE movie_shows ALTER COLUMN start_time DROP NOT NULL;
ALTER TABLE movie_shows ALTER COLUMN end_time DROP NOT NULL;

INSERT INTO movie_shows (movie_id,theater_id,sound_system_id,start_time,end_time) VALUES
(8,1,1, null, null),
(9,3,1, null, null),
(10,2,1, null, null),
(12,2,2, null, null),
(17,3,2, null, null);
