package com.example.RideSwift.dto.request;
import com.example.RideSwift.Enum.CarType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabRequest {
    String company;
    String cabNo;
    String carModel;
    CarType carType;
    int noOfSeats;
    double farePerkm;
}
