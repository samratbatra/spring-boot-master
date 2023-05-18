package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Autowired
    private Environment environment;

    @Value("${info.app.name}")
    private String companyName;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){

        return args -> {

            System.out.println("Command Line runner");

            System.out.println(companyName);

            System.out.println(environment.getProperty("info.app.version"));

            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo(){

        return useFakeCustomerRepo?
                new CustomerFakeRepository():
                new CustomerRepository();
    }

}
