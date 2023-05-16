package com.example.demo.customer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Deprecated
@RestController
@RequestMapping("/api/v1/customer")
public class CutomerController {

    public final CustomerService customerService;

    @Autowired
    public CutomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @PostMapping
    public void createCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST REQUEST");

    }


}
