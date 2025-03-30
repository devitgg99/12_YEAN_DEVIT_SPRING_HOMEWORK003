package org.example.springhomework003.service.ServiceImplement;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.entity.Event;
import org.example.springhomework003.repository.EventRepository;
import org.example.springhomework003.request.EventRequest;
import org.example.springhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    @Override
    public List<Event> getAllEvents(@Positive Integer page, @Positive Integer size) {
        page = (page - 1) * size;
        return eventRepository.getAllEvents(page, size);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.getEventById(eventId);
    }

    @Override
    public Event addEvent(EventRequest eventRequest) {
        return eventRepository.addEvent(eventRequest);
    }

    @Override
    public Event updateEventByEventId(Long eventID, EventRequest eventRequest) {
        return eventRepository.updateEventByEventId(eventID,eventRequest);
    }

    @Override
    public Event deleteEventByEventId(Long eventID) {
        return eventRepository.deleteEventByEventId(eventID);
    }
}
