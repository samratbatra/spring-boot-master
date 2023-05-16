package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers() {

        return customerRepo.getCustomers();
    }


    public Customer getCustomer(Long id) {

        return customerRepo.getCustomers().stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow(() ->
            new NotFoundException("Customer with id " + id + " not found") );
    }
}
