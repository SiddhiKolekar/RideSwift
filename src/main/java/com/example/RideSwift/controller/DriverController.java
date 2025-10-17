package com.example.RideSwift.controller;

import com.example.RideSwift.dto.request.DriverRequest;
import com.example.RideSwift.model.Driver;
import com.example.RideSwift.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
//    @Autowired
//    DriverService driverService;
    private final DriverService driverService;
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }
    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest){
        String response = driverService.addDriver(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/mob-no/{mob-no}")
    public Driver getDriver(@PathVariable("mob-no") String mobNo){
        return driverService.getDriver(mobNo);
    }
}
