package org.example.springhomework003.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VenueRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private final String venueName;
    @NotBlank(message = "Location is required")
    private final String location;
}
