package com.example.RideSwift.repository;

import com.example.RideSwift.model.TripBooking;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {
}
