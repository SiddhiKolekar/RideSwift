package com.example.RideSwift.dto.request;
import com.example.RideSwift.Enum.CarType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest {
    String company;
    String cabNo;
    String carModel;
    CarType carType;
    int noOfSeats;
    double farePerkm;
}
