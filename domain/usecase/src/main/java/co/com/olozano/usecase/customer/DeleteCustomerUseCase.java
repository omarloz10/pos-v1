package co.com.olozano.usecase.customer;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import co.com.olozano.model.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public void execute(UUID id) {
        Customer customer = customerRepository.findById(id);

        if (customer == null) {
            throw new NotFoundException("Customer with ID [" + id + "] Not Found");
        }

        customer = customer.toBuilder()
                .deleted(!customer.isDeleted())
                .build();

        customerRepository.delete(customer);
    }
}
