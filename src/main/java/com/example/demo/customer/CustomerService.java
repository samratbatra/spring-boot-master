package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers() {

        LOGGER.info("getCustomers was called");
        return customerRepo.getCustomers();
    }


    public Customer getCustomer(Long id) {
        return customerRepo.getCustomers().stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow(() -> {
            NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
            LOGGER.error("Error in getting  customer id {}", id,
                    notFoundException);

            return notFoundException;
        });
    }
}
