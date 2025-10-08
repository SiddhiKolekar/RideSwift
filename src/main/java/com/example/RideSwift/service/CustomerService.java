package com.example.RideSwift.service;

import com.example.RideSwift.dto.request.CustomerRequest;
import com.example.RideSwift.dto.response.CustomerResponse;
import com.example.RideSwift.model.Customer;
import com.example.RideSwift.repository.CustomerRepository;
import com.example.RideSwift.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        //dto -> entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        //save customer
        Customer savedCustomer = customerRepository.save(customer);
        //entity -> response dto
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }
}
