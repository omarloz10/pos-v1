package co.com.olozano.jpa.customer;

import co.com.olozano.jpa.entity.CustomerEntity;
import co.com.olozano.jpa.helper.AdapterOperations;
import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public PaginationResult<Customer> findCustomers(PaginationQuery paginationQuery) {
        Pageable pageable = PageRequest.of(paginationQuery.getPage(), paginationQuery.getSize());
        Page<CustomerEntity> page = repository.findAll(pageable);
        List<Customer> customers = page.getContent().stream()
                .map(customer -> mapper.map(customer, Customer.class))
                .toList();

        return new PaginationResult<>(customers, page.getTotalPages(), page.getTotalElements());
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
