package com.example.RideSwift.model;

import com.example.RideSwift.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String bookingId; //UUID
    String source;
    String destination;
    double tripDistanceInKm;
    double totalFare;
    TripStatus tripStatus;
    @CreationTimestamp
    Date bookedAt;
    @ManyToOne
          @JoinColumn
    Customer customer;
    @ManyToOne
    @JoinColumn
    Driver driver;
}
