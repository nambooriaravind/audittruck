package com.audit.truck.repo;

import com.audit.truck.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByTripDateBetween(LocalDate startDate, LocalDate endDate);
}
