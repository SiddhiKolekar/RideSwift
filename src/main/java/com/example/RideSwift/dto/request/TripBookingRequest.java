package com.example.RideSwift.dto.request;

import com.example.RideSwift.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingRequest {
    String source;
    String destination;
    double tripDistanceInKm;
    double totalFare;
    TripStatus tripStatus;
    String customerEmailId;
}
