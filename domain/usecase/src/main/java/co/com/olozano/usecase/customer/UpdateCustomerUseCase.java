package co.com.olozano.usecase.customer;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RequiredArgsConstructor
public class UpdateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public Customer execute(UUID id, Customer customerData) {

        Customer customer = customerRepository.findById(id);

        if (customer == null) {
            throw new RuntimeException("Customer Not Found!");
        }

        customer = customer.toBuilder()
                .name(customerData.getName())
                .lastname(customerData.getLastname())
                .age((int) ChronoUnit.YEARS.between(customerData.getBirthdate(), LocalDate.now()))
                .documentType(customerData.getDocumentType())
                .documentNumber(customerData.getDocumentNumber())
                .numberPhone(customerData.getNumberPhone())
                .email(customerData.getEmail())
                .address(customerData.getAddress())
                .gender(customerData.getGender())
                .birthdate(customerData.getBirthdate())

                .build();

        return customerRepository.update(customer);
    }
}
