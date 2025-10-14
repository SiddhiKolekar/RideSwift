package com.example.RideSwift.service;

import com.example.RideSwift.dto.request.TripBookingRequest;
import com.example.RideSwift.dto.response.TripBookingResponse;
import com.example.RideSwift.exception.CabNotAvailableException;
import com.example.RideSwift.exception.CustomerNotFoundException;
import com.example.RideSwift.model.Cab;
import com.example.RideSwift.model.Customer;
import com.example.RideSwift.model.TripBooking;
import com.example.RideSwift.repository.CustomerRepository;
import com.example.RideSwift.repository.DriverRepository;
import com.example.RideSwift.repository.TripBookingRepository;
import com.example.RideSwift.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {
    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final TripBookingRepository tripBookingRepository;
    public TripBookingResponse bookCab(boolean applyCoupon, TripBookingRequest tripBookingRequest) {
        //validate email id of the customer
        Customer customer = customerRepository.findByEmailId(tripBookingRequest.getCustomerEmailId());
        if(customer == null){
            throw new CustomerNotFoundException("Invalid email id");
        }

        //check if a cab is available or not
        //get a random available cab
        Cab cab = cabRepository.getRandomAvailableCab();
        if (cab == null){
            throw new CabNotAvailableException("Sorry! all drivers are busy right now!!");
        }

        //prepare the booking entity
        TripBooking tripBooking = BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerkm() * tripBookingRequest.getTripDistanceInKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        //save booking
        TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);
        customer.getBookings().add(tripBooking);
        cab.setAvailable(false);

        cab.getDriver().getBookings().add(tripBooking);

        customerRepository.save(customer); //customer and savedBooking
        driverRepository.save(cab.getDriver()); //driver + cab + savedBooking

        //prepare booking response
        return BookingTransformer.tripBookingToTripBookingResponse(savedTripBooking);
    }
}
