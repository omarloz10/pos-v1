package co.com.olozano.usecase.customer;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllCustomersUseCase {

    private final CustomerRepository customerRepository;

    public List<Customer> execute(){
        return customerRepository.findAll();
    }
}
