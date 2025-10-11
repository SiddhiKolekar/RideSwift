package com.example.RideSwift.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabResponse {
    String cabNo;
    String carModel;
    double farePerkm;
}
