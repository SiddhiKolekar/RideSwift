package com.example.RideSwift.service;

import com.example.RideSwift.dto.request.TripBookingRequest;
import com.example.RideSwift.dto.response.TripBookingResponse;
import com.example.RideSwift.exception.CustomerNotFoundException;
import com.example.RideSwift.model.Customer;
import com.example.RideSwift.repository.CustomerRepository;
import com.example.RideSwift.repository.TripBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {
    private final CustomerRepository customerRepository;
    public TripBookingResponse bookCab(boolean applyCoupon, TripBookingRequest tripBookingRequest) {
        //validate email id of the customer
        Customer customer = customerRepository.findByEmailId(tripBookingRequest.getCustomerEmailId());
        if(customer.equals(null)){
            throw new CustomerNotFoundException("Invalid email id");
        }
    }
}
