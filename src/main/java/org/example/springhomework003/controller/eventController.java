package org.example.springhomework003.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.springhomework003.exception.NotFoundException;
import org.example.springhomework003.model.entity.Event;
import org.example.springhomework003.repository.AttendeeRepository;
import org.example.springhomework003.repository.EventAttendeeRepository;
import org.example.springhomework003.repository.venueRepository;
import org.example.springhomework003.request.EventRequest;
import org.example.springhomework003.response.ApiResponse;
import org.example.springhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/events")
public class eventController {
    private final EventService eventService;
    private final EventAttendeeRepository eventAttendeeRepository;
    private final venueRepository venueRepository;
    private final AttendeeRepository attendeeRepository;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvents(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size){
        List<Event> events = eventService.getAllEvents(page,size );
        return ResponseEntity.ok().body(new ApiResponse<>("Done" ,events , HttpStatus.OK));
    }

    @GetMapping("/{event-Id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@PathVariable("event-Id") @Positive Long eventId) {
        Event events = eventService.getEventById(eventId);
        if(events == null){
            throw new NotFoundException("Event "+eventId+" not found");
        }
        return ResponseEntity.ok().body(new ApiResponse<>("Done" ,events , HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Event>> addEvent(@Valid @RequestBody EventRequest eventRequest){
        if(venueRepository.getVenueById(eventRequest.getVenueId()) == null ){
            throw new NotFoundException("Venue "+eventRequest.getVenueId()+" not found");
        }
        Event event = eventService.addEvent(eventRequest);
        for(Long attendeeId : eventRequest.getAttendeeId()){
            if( attendeeRepository.getAttendeeById(attendeeId) == null){
                throw new NotFoundException("Attendee "+attendeeId+" not found");
            }
            eventAttendeeRepository.addIntoEventAttendee(event.getEventId(), attendeeId);
        }
        return ResponseEntity.ok().body(new ApiResponse<>("Done" ,event , HttpStatus.OK));
    }
    @PutMapping("/{eventID}")
    public ResponseEntity<ApiResponse<Event>> updateEvent(@Positive @PathVariable("eventID") Long eventID,@Valid @RequestBody EventRequest eventRequest){
        if(venueRepository.getVenueById(eventRequest.getVenueId()) == null ){
            throw new NotFoundException("Venue "+eventRequest.getVenueId()+" not found");
        }
        Event event = eventService.updateEventByEventId(eventID,eventRequest);
        if(getEventById(eventID) == null){
            throw new NotFoundException("Event "+eventID+" not found");
        }
        eventAttendeeRepository.deleteEventAttendee(eventID);
        for(Long attendeeId : eventRequest.getAttendeeId()){
            if( attendeeRepository.getAttendeeById(attendeeId) == null){
                throw new NotFoundException("Attendee "+attendeeId+" not found");
            }
            eventAttendeeRepository.addIntoEventAttendee(eventID, attendeeId);
        }
        return ResponseEntity.ok().body(new ApiResponse<>("Update Done" ,event , HttpStatus.OK));
    }
    @DeleteMapping("/{eventID}")
    public ResponseEntity<ApiResponse<Void>> deleteEvent(@Positive @PathVariable("eventID") Long eventID){
        if( getEventById(eventID) == null){
            throw new NotFoundException("Attendee "+eventID+" not found");
        }
        Event event = eventService.deleteEventByEventId(eventID);
        eventAttendeeRepository.deleteEventAttendee(eventID);
       return ResponseEntity.ok().body(new ApiResponse<>("Done" ,null , HttpStatus.OK));
    }
}
