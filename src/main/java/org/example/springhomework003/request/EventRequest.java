package org.example.springhomework003.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class EventRequest {

    @NotBlank(message = "eventName is required")
    private final String eventName;

    @NotNull(message = "eventDate is required")
    @Future(message = "Event date must be in the future")
    private final LocalDate eventDate;

    @Min(value = 1, message = "Venue ID must be greater than or equal to 1")
    private final Long venueId;
    private final List<Long> attendeeId;
}