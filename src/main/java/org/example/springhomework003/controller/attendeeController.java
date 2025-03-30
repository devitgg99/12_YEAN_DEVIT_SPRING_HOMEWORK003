package org.example.springhomework003.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.entity.Attendee;
import org.example.springhomework003.request.AttendeeRequest;
import org.example.springhomework003.response.ApiResponse;
import org.example.springhomework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/attendees")
public class attendeeController {
    private final AttendeeService attendeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees(@Positive @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        List<Attendee> attendee = attendeeService.getAllAttendee(page,size);
        return ResponseEntity.ok().body(new ApiResponse<>("done",attendee, HttpStatus.OK));
    }

    @GetMapping("/{attendee-Id}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable("attendee-Id") @Positive Long attendeeId){
        Attendee attendee = attendeeService.getAttendeeById(attendeeId);
        return ResponseEntity.ok().body(new ApiResponse<>("done",attendee, HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> addAttendee(@Valid @RequestBody AttendeeRequest attendeeRequest){
        Attendee attendee = attendeeService.addAttendee(attendeeRequest);
        return ResponseEntity.ok().body(new ApiResponse<>("done",attendee, HttpStatus.OK));
    }
    @PutMapping("/{attendee-Id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendeeById(@PathVariable("attendee-Id") @Positive Integer attendeeId, @Valid @RequestBody AttendeeRequest attendeeRequest){
        Attendee attendee = attendeeService.updateAttendeeById(attendeeId,attendeeRequest);
        return ResponseEntity.ok().body(new ApiResponse<>("done",attendee, HttpStatus.OK));
    }

    @DeleteMapping("/{attendee-Id}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendee(@PathVariable("attendee-Id") @Positive Integer attendeeID){
        Attendee attendee = attendeeService.deleteAttendeeById(attendeeID);
        return ResponseEntity.ok().body(new ApiResponse<>("Delete Successfully",null, HttpStatus.OK));
    }
}
