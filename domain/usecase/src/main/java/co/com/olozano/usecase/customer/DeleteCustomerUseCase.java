package co.com.olozano.usecase.customer;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public void execute(UUID id) {
        Customer customer = customerRepository.findById(id);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        customer = customer.toBuilder()
                .deleted(true)
                .build();

        customerRepository.delete(customer);
    }
}
