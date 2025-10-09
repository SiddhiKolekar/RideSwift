package com.example.RideSwift.service;

import com.example.RideSwift.dto.request.CabRequest;
import com.example.RideSwift.dto.request.DriverRequest;
import com.example.RideSwift.model.Cab;
import com.example.RideSwift.model.Driver;
import com.example.RideSwift.repository.DriverRepository;
import com.example.RideSwift.transformer.CabTransformer;
import com.example.RideSwift.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
//    @Autowired
//    DriverRepository driverRepository;
    private final DriverRepository driverRepository;
    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }
    public String addDriver(DriverRequest driverRequest){
        CabRequest cabRequest = driverRequest.getCab();

        //driver request -> driver
        //cab request -> cab
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());

        //set the relationship attributes
        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver); //save both driver and cab
        return "Driver and cab saved successfully";
    }

    //delete a driver by mobNo (don't manually get the cab)
}
