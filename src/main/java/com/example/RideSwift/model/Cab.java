package com.example.RideSwift.model;

import com.example.RideSwift.Enum.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true, nullable = false)
    String cabNo;
    String carModel;
    boolean available;
    @Enumerated(EnumType.STRING)
    CarType carType;
    int noOfSeats;
    double farePerkm;
    @OneToOne
            @JoinColumn(name = "driver_id")
            @JsonIgnore
    Driver driver;
}
