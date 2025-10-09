package com.example.RideSwift.model;

import com.example.RideSwift.Enum.CarType;
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

    String company;
    @Column(unique = true, nullable = false)
    String cabNo;
    String carModel;
    @Enumerated(EnumType.STRING)
    CarType carType;
    int noOfSeats;
    double farePerkm;
    @OneToOne
            @JoinColumn(name = "driver_id")
    Driver driver;
}
