INSERT INTO venues (venue_id, venue_name, location)
values (default, 'camp1', 'pp'),(default, 'camp2', 'sr'),(default, 'camp3', 'btb')


INSERT INTO events (event_id, event_name, event_date, venue_id)
VALUES
(default, 'Concert', '2025-04-15', 5),
(default, 'Art Exhibition', '2025-05-20', 7),
(default, 'Tech Conference', '2025-06-10', 6),
(default, 'Food Festival', '2025-07-05', 7),
(default, 'Charity Run', '2025-08-25', 5);



INSERT INTO attendees ( attendee_name , email)
VALUES ('many','many@gmail.com'),
       ('roth','roth@gmail.com'),
       ('relaxsun','relaxsun@gmail.com'),
       ('enghour','enghour@gmail.com'),
       ('devit','devit@gmail.com')


INSERT INTO event_attendee (id, event_id, attendee_id)
VALUES (default,1,2),
       (default,2,2),
       (default,1,3),
       (default,3,1),
       (default,3,2),


SELECT a.* FROM attendees a
INNER JOIN event_attendee e ON a.attendee_id = e.attendee_id
WHERE e.event_id = 1