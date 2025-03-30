package org.example.springhomework003.service;

import jakarta.validation.Valid;
import org.example.springhomework003.model.entity.Venue;
import org.example.springhomework003.request.VenueRequest;

import java.util.List;

public interface VenueService {

    List<Venue> getAllVenue(Integer page, Integer size);

    Venue getVenueById(Long id);

    Venue addVenue(@Valid VenueRequest venueRequest);

    Venue updateVenueById(@Valid Long venueID, VenueRequest venueRequest);

    Venue deleteVenueById(Long venueID);
}
