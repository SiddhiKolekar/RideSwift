package com.example.RideSwift.transformer;

import com.example.RideSwift.dto.request.CabRequest;
import com.example.RideSwift.dto.response.CabResponse;
import com.example.RideSwift.model.Cab;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNo(cabRequest.getCabNo())
                .carModel(cabRequest.getCarModel())
                .farePerkm(cabRequest.getFarePerkm())
                .noOfSeats(cabRequest.getNoOfSeats())
                .carType(cabRequest.getCarType())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .carModel(cab.getCarModel())
                .farePerkm(cab.getFarePerkm())
                .build();
    }

}
