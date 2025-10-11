package com.example.RideSwift.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverResponse {
    String name;
    double rating;
    String mobNo;
    CabResponse cabResponse;
}
