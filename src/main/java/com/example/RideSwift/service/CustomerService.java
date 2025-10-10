package com.example.RideSwift.service;

import com.example.RideSwift.Enum.Gender;
import com.example.RideSwift.dto.request.CustomerRequest;
import com.example.RideSwift.dto.response.CustomerResponse;
import com.example.RideSwift.model.Customer;
import com.example.RideSwift.repository.CustomerRepository;
import com.example.RideSwift.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
//    @Autowired
//    CustomerRepository customerRepository;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        //dto -> entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        //save customer
        Customer savedCustomer = customerRepository.save(customer);
        //entity -> response dto
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getByGenderAndAgeGreaterThan(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }
}
