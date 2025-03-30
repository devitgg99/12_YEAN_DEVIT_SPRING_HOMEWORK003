create table venues(
    venue_id SERIAL primary key,
    venue_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
)


create table events (
    event_id SERIAL primary key,
    event_name VARCHAR(100) NOT NULL,
    event_date TIMESTAMP NOT NULL,
    venue_id INT NOT NULL,
    CONSTRAINT fk_venue foreign key(venue_id) REFERENCES venues (venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);


create table attendees (
    attendee_id SERIAL PRIMARY KEY,
    attendee_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
)



Create table event_attendee(
    id SERIAL PRIMARY KEY,
    event_id INT NOT NULL,
    attendee_id INT NOT Null,
    CONSTRAINT fk_event FOREIGN KEY(event_id) REFERENCES events (event_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_attendee FOREIGN KEY(attendee_id) REFERENCES attendees (attendee_id) ON DELETE CASCADE ON UPDATE CASCADE
)


