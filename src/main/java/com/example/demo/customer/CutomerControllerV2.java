package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/customer")
public class CutomerControllerV2 {

    public final CustomerService customerService;

    @Autowired
    public CutomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    Customer getCustomer(
            @PathVariable("customerId") Long id
    ){
        return customerService.getCustomer(id);
    }


    @PostMapping
    public void createCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST REQUEST");

    }

    @GetMapping("/{customerId}/exception")
    Customer getCustomerException(
            @PathVariable("customerId") Long id
    ){
        throw  new ApiRequestException(
                "ApiRequestException for customer " + id);
    }
}
