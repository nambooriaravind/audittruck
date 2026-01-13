package com.audit.truck.service;

import com.audit.truck.dto.TripRequest;
import com.audit.truck.entity.Trip;
import com.audit.truck.repo.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip createTrip(TripRequest request) {

        Trip trip = new Trip();
        trip.setTripDate(request.getTripDate());
        trip.setSourceLocation(request.getSourceLocation());
        trip.setDestinationLocation(request.getDestinationLocation());
        trip.setMaterialCarried(request.getMaterialCarried());
        trip.setNotes(request.getNotes());

        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public void deleteTrip(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        tripRepository.delete(trip);
    }

}
