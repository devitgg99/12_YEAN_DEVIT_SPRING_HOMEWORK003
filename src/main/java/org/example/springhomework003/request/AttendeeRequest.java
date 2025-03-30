package org.example.springhomework003.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AttendeeRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private final String attendeeName;
    @NotBlank(message = "Email is required")
    private final String email;
}
