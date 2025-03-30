package org.example.springhomework003.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.springhomework003.model.entity.Attendee;
import org.example.springhomework003.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {

    List<Attendee> getAllAttendee(@Positive Integer page, Integer size);

    Attendee getAttendeeById(@Positive Long attendeeId);

    Attendee addAttendee(@Valid AttendeeRequest attendeeRequest);

    Attendee updateAttendeeById(@Positive Integer attendeeId, @Valid AttendeeRequest attendeeRequest);

    Attendee deleteAttendeeById(Integer attendeeID);
}
