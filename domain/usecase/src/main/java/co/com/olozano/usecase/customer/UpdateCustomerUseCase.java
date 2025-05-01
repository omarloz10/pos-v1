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
                .person(customer.getPerson().toBuilder()
                        .name(customerData.getPerson().getName())
                        .lastname(customerData.getPerson().getLastname())
                        .age((int) ChronoUnit.YEARS.between(customerData.getPerson().getBirthdate(), LocalDate.now()))
                        .documentType(customerData.getPerson().getDocumentType())
                        .documentNumber(customerData.getPerson().getDocumentNumber())
                        .numberPhone(customerData.getPerson().getNumberPhone())
                        .email(customerData.getPerson().getEmail())
                        .address(customerData.getPerson().getAddress())
                        .gender(customerData.getPerson().getGender())
                        .birthdate(customerData.getPerson().getBirthdate())
                        .build())
                .build();

        return customerRepository.update(customer);
    }
}
