INSERT INTO locations (name) VALUES ('Chennai');
INSERT INTO locations (name) VALUES ('Trichy');
INSERT INTO locations (name) VALUES ('Madurai');


INSERT INTO "theaters" (id,name,location_id,capacity) VALUES
(1,'PVR',2,500),
(2,'DT Cinemas',3,400),
(3,'TW Cinemas',2,200),
(4,'SPI Cinemas',3,300),
(5,'Omaxe',1,300);

INSERT INTO sound_systems (type) values ('Dolby'), ('IMAX'), ('Standard');

INSERT INTO movie_shows (movie_id,theater_id,sound_system_id,start_time,end_time) VALUES
(7,1,1,'2019-01-29 19:10','2019-01-29 21:10'),
(1,1,1,'2019-01-30 10:00','2019-01-29 13:00'),
(5,2,1,'2019-02-28 10:00','2019-01-29 12:00'),
(2,2,2,'2019-02-28 12:00','2019-01-29 14:00'),
(3,3,2,'2019-02-15 10:00','2019-01-29 12:00'),
(6,4,3,'2019-02-15 14:00','2019-01-29 16:00'),
(4,5,3,'2019-02-15 15:00','2019-01-29 17:00');
