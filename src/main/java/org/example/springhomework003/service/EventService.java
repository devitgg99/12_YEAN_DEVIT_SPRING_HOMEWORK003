package org.example.springhomework003.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.springhomework003.model.entity.Event;
import org.example.springhomework003.request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(@Positive Integer page, @Positive Integer size);

    Event getEventById(@Positive Integer eventId);

    Event addEvent(@Valid EventRequest eventRequest);

    Event updateEventByEventId(@Positive Long eventID, @Valid EventRequest eventRequest);

    Event deleteEventByEventId(@Positive Long eventID);
}
