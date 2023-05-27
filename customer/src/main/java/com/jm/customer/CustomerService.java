package com.jm.customer;

import com.jm.clients.fraud.FraudCheckResponse;
import com.jm.clients.fraud.FraudClient;
import com.jm.clients.notification.NotificationClient;
import com.jm.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              FraudClient fraudClient,
                              NotificationClient notificationClient) {
    public void registerCustomer(CustomerRegistrationRequest request) throws illegalStateException {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

//        //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new illegalStateException("fraudster");
        }

        //todo: check if email valid
        //todo: check if email is not taken

        //todo: send notification
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to Jocyline ...",
                                customer.getFirstName())
                        )
        );


    }


    public List<Customer> getCustomers() {
        return  customerRepository.findAll();
    }
}
