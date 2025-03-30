package org.example.springhomework003.service.ServiceImplement;

import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.entity.Venue;
import org.example.springhomework003.repository.venueRepository;
import org.example.springhomework003.request.VenueRequest;
import org.example.springhomework003.service.VenueService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
@RequiredArgsConstructor
public class venueServiceImpl implements VenueService {
    private final venueRepository venueRepository;

    @Override
    public List<Venue> getAllVenue(Integer page, Integer size) {
        page = (page - 1) * size;
        return venueRepository.getAllVenue(page, size);
    }

    @Override
    public Venue getVenueById(Integer id) {
        return venueRepository.getVenueById(id);
    }

    @Override
    public Venue addVenue(VenueRequest venueRequest) {
        return venueRepository.addVenue(venueRequest);
    }

    @Override
    public Venue updateVenueById(Long venueID, VenueRequest venueRequest) {
        return venueRepository.updateVenueById(venueID, venueRequest);
    }

    @Override
    public Venue deleteVenueById(Long venueID) {
        return venueRepository.deleteVenueById(venueID);
    }
}
