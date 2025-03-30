package org.example.springhomework003.service.ServiceImplement;

import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.entity.Attendee;
import org.example.springhomework003.repository.AttendeeRepository;
import org.example.springhomework003.request.AttendeeRequest;
import org.example.springhomework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Attendee> getAllAttendee(Integer page, Integer size) {
        page = (page - 1) * size;
        return attendeeRepository.getAllAttendee(page,size);
    }

    @Override
    public Attendee getAttendeeById(Long attendeeId) {
        return attendeeRepository.getAttendeeById(attendeeId);
    }

    @Override
    public Attendee addAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.addAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest) {
        return attendeeRepository.updateAttendeeById(attendeeId,attendeeRequest);
    }

    @Override
    public Attendee deleteAttendeeById(Integer attendeeID) {
        return attendeeRepository.deleteAttendeeById(attendeeID);
    }
}
