package com.jm.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController( CustomerService customerService) {
    @PostMapping
    public void customerRegistration(
            @RequestBody CustomerRegistrationRequest customerRegistrationRequest)
            throws illegalStateException {
        log.info("new Customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return  customerService.getCustomers();
    }
}
