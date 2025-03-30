package org.example.springhomework003.request;


import jakarta.validation.constraints.NotBlank;
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
    private final LocalDate eventDate = LocalDate.now();
    @NotNull(message = "venueId is required")
    private final Long venueId;
    @NotNull(message = "attendeeId is required")
    private final List<Long> attendeeId;
}
