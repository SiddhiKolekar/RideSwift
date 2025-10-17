package com.example.RideSwift.controller;

import com.example.RideSwift.dto.response.Response;
import com.example.RideSwift.dto.response.TripBookingResponse;
import com.example.RideSwift.exception.CabNotAvailableException;
import com.example.RideSwift.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppControllerAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({CustomerNotFoundException.class,
            CabNotAvailableException.class})
    public ResponseEntity<TripBookingResponse> handleException(Exception ex){
        TripBookingResponse response = TripBookingResponse.builder()
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
