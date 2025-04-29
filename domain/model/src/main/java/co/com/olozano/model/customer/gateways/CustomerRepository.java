package co.com.olozano.model.customer.gateways;

import co.com.olozano.model.customer.Customer;

public interface CustomerRepository {

    Customer save(Customer customer);
}
