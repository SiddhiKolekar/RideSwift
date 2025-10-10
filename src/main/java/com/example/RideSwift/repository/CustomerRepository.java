package com.example.RideSwift.repository;

import com.example.RideSwift.Enum.Gender;
import com.example.RideSwift.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
//   @Query(value = "select * from customer where gender = :g and age >= :age", nativeQuery = true)
//    List<Customer> getByGenderAndAgeGreaterThan(String g, int age);

    @Query(value = "select c from Customer c where c.gender = :g and c.age >= :age") //sql
    List<Customer> getByGenderAndAgeGreaterThan(Gender g, int age);
}
