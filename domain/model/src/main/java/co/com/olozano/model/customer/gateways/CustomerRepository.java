package co.com.olozano.model.customer.gateways;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {

    PaginationResult<Customer> findCustomers(PaginationQuery paginationQuery);

    List<Customer> findAll();

    Customer findById(UUID id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(Customer customer);
}
