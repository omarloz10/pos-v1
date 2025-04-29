package co.com.olozano.jpa.customer;

import co.com.olozano.jpa.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerEntity/* change for adapter model */, UUID>,
        QueryByExampleExecutor<CustomerEntity/* change for adapter model */> {
}
