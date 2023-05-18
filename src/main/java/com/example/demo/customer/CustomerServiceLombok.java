package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceLombok {


    private final CustomerRepo customerRepo;



    public List<Customer> getCustomers() {

        log.info("getCustomers was called");
        return customerRepo.getCustomers();
    }


    public Customer getCustomer(Long id) {
        return customerRepo.getCustomers().stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow(() -> {
            NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
            log.error("Error in getting  customer id {}", id,
                    notFoundException);

            return notFoundException;
        });
    }
}
