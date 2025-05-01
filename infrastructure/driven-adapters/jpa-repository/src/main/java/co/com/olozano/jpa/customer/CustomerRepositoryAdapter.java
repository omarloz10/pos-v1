package co.com.olozano.jpa.customer;

import co.com.olozano.jpa.entity.CustomerEntity;
import co.com.olozano.jpa.helper.AdapterOperations;
import co.com.olozano.model.customer.Customer;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CustomerRepositoryAdapter extends AdapterOperations<Customer/* change for domain model */, CustomerEntity/* change for adapter model */, UUID, CustomerRepository>
// implements ModelRepository from domain
        implements co.com.olozano.model.customer.gateways.CustomerRepository {

    public CustomerRepositoryAdapter(CustomerRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Customer.class/* change for domain model */));
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity entity = repository.save(mapper.map(customer, CustomerEntity.class));
        return mapper.map(entity, Customer.class);
    }

    @Override
    public void delete(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }
}
