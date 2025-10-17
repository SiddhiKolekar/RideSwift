package com.example.RideSwift.dto.response;

import com.example.RideSwift.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBookingResponse {
    String bookingId;
    String pickup;
    String source;
    String destination;
    double tripDistanceInKm;
    double totalFare;
    TripStatus tripStatus;
    Date bookedAt;
    CustomerResponse customerResponse;
    DriverResponse driverResponse;
    String message;
}
