package com.example.RideSwift.transformer;

import com.example.RideSwift.dto.request.CabRequest;
import com.example.RideSwift.model.Cab;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .company(cabRequest.getCompany())
                .cabNo(cabRequest.getCabNo())
                .carModel(cabRequest.getCarModel())
                .farePerkm(cabRequest.getFarePerkm())
                .noOfSeats(cabRequest.getNoOfSeats())
                .carType(cabRequest.getCarType())
                .build();
    }
}
