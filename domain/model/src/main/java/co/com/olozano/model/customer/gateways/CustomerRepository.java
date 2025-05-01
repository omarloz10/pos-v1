package co.com.olozano.model.customer.gateways;

import co.com.olozano.model.customer.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findById(UUID id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(Customer customer);
}
