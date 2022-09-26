package com.jm.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public record CustomerService( List customers,
                               CustomerRepository customerRepository, RestTemplate restTemplate) {
    public void registerCustomer(CustomerRegistrationRequest request) throws illegalStateException {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        //todo: check if fraudster
        String uri = "http://FRAUD/api/v1/fraud-check/{customerID}";
        FraudCheckResponse fraudCheckResponse = restTemplate.
                getForObject(uri,
                        FraudCheckResponse.class,
                        customer.getId()
                );
        if(fraudCheckResponse.isFraudster()){
            throw new illegalStateException("fraudster");
        }

        //todo: check if email valid
        //todo: check if email is not taken

        //todo: send notification
    }


    public List<Customer> getCustomers() {
        return  customerRepository.findAll();
    }
}
