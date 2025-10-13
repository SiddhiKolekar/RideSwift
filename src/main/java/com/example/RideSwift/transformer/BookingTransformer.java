package com.example.RideSwift.transformer;

import com.example.RideSwift.Enum.TripStatus;
import com.example.RideSwift.dto.request.TripBookingRequest;
import com.example.RideSwift.model.TripBooking;

import java.util.UUID;

public class BookingTransformer {
    public static TripBooking bookingRequestToBooking(TripBookingRequest tripBookingRequest){
        return TripBooking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(tripBookingRequest.getPickup())
                .destination(tripBookingRequest.getDestination())
                .tripDistanceInKm(tripBookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.IN_TRANSIT)
                .build();
    }
}
