package co.com.olozano.usecase.customer;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllCustomersUseCase {

    private final CustomerRepository customerRepository;

    public PaginationResult
            <Customer> execute(int page, int size) {
        return customerRepository.findCustomers(new PaginationQuery(page, size));
    }
}
