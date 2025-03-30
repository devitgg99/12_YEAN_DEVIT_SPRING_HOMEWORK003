package org.example.springhomework003.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.example.springhomework003.exception.NotFoundException;
import org.example.springhomework003.model.entity.Venue;
import org.example.springhomework003.request.VenueRequest;
import org.example.springhomework003.response.ApiResponse;
import org.example.springhomework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/venues")
public class venueController {
    private final VenueService venueService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>>  getAllVenues(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
        List<Venue> venues = venueService.getAllVenue(page,size);
        return ResponseEntity.ok().body(new ApiResponse<>("Done",venues,OK));
    }
    @GetMapping("/{VenueID}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable("VenueID") Long id) {
        Venue venues = venueService.getVenueById(id);
        if (venues == null) {
            throw new NotFoundException("Venue not found");
        }
        return ResponseEntity.ok().body(new ApiResponse<>("Done",venues,OK));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> addVenue(@Valid @RequestBody VenueRequest venueRequest) {
        Venue venue = venueService.addVenue(venueRequest);
        return ResponseEntity.ok().body(new ApiResponse<>("Done",venue,OK));
    }
    @PutMapping("/{venueID}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable("venueID") @Positive Long venueID ,@Valid @RequestBody VenueRequest venueRequest) {
        Venue venue = venueService.updateVenueById(venueID, venueRequest);
        return ResponseEntity.ok().body(new ApiResponse<>("Done",venue,OK));
    }
    @DeleteMapping("/{venueID}")
    public ResponseEntity<ApiResponse<Void>> deleteVenueById(@PathVariable("venueID") @Positive Long venueID) {
        Venue venue = venueService.deleteVenueById(venueID);
        return ResponseEntity.ok().body(new ApiResponse<>("Done",null,OK));
    }
}
