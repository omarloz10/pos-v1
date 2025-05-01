package co.com.olozano.usecase.customer;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public Customer execute(Customer customer) {
        return customerRepository.save(customer);
    }
    
}
