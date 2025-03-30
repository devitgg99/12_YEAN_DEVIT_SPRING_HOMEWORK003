create table venues(
    venue_id SERIAL primary key,
    venue_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
)

INSERT INTO venues (venue_id, venue_name, location)
values (default, 'camp1', 'pp'),(default, 'camp2', 'sr'),(default, 'camp3', 'btb')

create table events (
    event_id SERIAL primary key,
    event_name VARCHAR(100) NOT NULL,
    event_date TIMESTAMP NOT NULL,
    venue_id INT NOT NULL,
    CONSTRAINT fk_venue foreign key(venue_id) REFERENCES venues (venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO events (event_id, event_name, event_date, venue_id)
VALUES
(default, 'Concert', '2025-04-15', 5),
(default, 'Art Exhibition', '2025-05-20', 7),
(default, 'Tech Conference', '2025-06-10', 6),
(default, 'Food Festival', '2025-07-05', 7),
(default, 'Charity Run', '2025-08-25', 5);

create table attendees (
    attendee_id SERIAL PRIMARY KEY,
    attendee_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
)

INSERT INTO attendees ( attendee_name , email)
VALUES ('many','many@gmail.com'),
       ('roth','roth@gmail.com'),
       ('relaxsun','relaxsun@gmail.com'),
       ('enghour','enghour@gmail.com'),
       ('devit','devit@gmail.com')