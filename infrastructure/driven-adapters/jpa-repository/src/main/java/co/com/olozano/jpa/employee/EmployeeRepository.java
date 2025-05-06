package co.com.olozano.jpa.employee;

import co.com.olozano.jpa.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface EmployeeRepository extends
        PagingAndSortingRepository<EmployeeEntity, UUID>,
        CrudRepository<EmployeeEntity/* change for adapter model */, UUID>,
        QueryByExampleExecutor<EmployeeEntity/* change for adapter model */> {
}
