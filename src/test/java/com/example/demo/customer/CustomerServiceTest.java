package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L, "Jamila", "jamila@gmail.com", "password");
        Customer ally = new Customer(2L, "Jamila", "jamila@gmail.com", "password");

        customerRepository.saveAll(Arrays.asList(jamila, ally));

        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
//given
        Customer jamila = new Customer(1L, "Jamila", "jamila@gmail.com", "password");

        customerRepository.save(jamila);
//when
        Customer actual = underTest.getCustomer(1L);
//then
        assertEquals(1l, actual.getId());
        assertEquals("jamila@gmail.com", actual.getEmail());
        assertEquals("Jamila", actual.getName());
        assertEquals("password", actual.getPassword());
    }
}