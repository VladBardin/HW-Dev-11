INSERT INTO client (name)
VALUES ('Mojo'),
       ('Torg'),
       ('Captain of America'),
       ('Iron man'),
       ('Black widow'),
       ('Spider man'),
       ('Spilberg'),
       ('Someone unknown'),
       ('Mister ring'),
       ('Lolo');

 INSERT INTO Planet (id, name)
 VALUES ('MOON51', 'Moon'),
         ('VENUS62', 'Venus'),
         ('SATURN258', 'Saturn'),
         ('MARS82', 'Mars'),
         ('MERCURY2', 'Mercury');

INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id)
     VALUES   ('2023-03-17 10:30:00', 1, 'MOON51', 'SATURN258'),
              ('2023-03-18 12:45:00', 3, 'VENUS62', 'MOON51'),
              ('2023-03-19 09:15:00', 2, 'SATURN258', 'VENUS62'),
              ('2023-03-20 15:30:00', 5, 'MARS82', 'SATURN258'),
              ('2023-03-21 11:00:00', 7, 'MERCURY2', 'MARS82'),
              ('2023-03-22 13:20:00', 4, 'MERCURY2', 'MARS82'),
              ('2023-03-23 16:10:00', 6, 'SATURN258', 'VENUS62'),
              ('2023-03-24 14:30:00', 8, 'VENUS62', 'MOON51'),
              ('2023-03-25 08:45:00', 9, 'SATURN258', 'VENUS62'),
              ('2023-03-26 07:30:00', 10, 'VENUS62', 'MOON51');



