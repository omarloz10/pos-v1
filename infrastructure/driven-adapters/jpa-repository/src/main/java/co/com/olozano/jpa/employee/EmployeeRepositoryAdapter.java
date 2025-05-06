package co.com.olozano.jpa.employee;

import co.com.olozano.jpa.entity.EmployeeEntity;
import co.com.olozano.jpa.helper.AdapterOperations;
import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepositoryAdapter extends AdapterOperations<Employee/* change for domain model */, EmployeeEntity/* change for adapter model */, UUID, EmployeeRepository>
// implements ModelRepository from domain
        implements co.com.olozano.model.employee.gateways.EmployeeRepository {

    public EmployeeRepositoryAdapter(EmployeeRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Employee.class/* change for domain model */));
    }

    @Override
    public PaginationResult<Employee> findCustomers(PaginationQuery paginationQuery) {

        Pageable pageable = PageRequest.of(paginationQuery.getPage(), paginationQuery.getSize(), Sort.by("createdAt").descending());

        Page<EmployeeEntity> page = repository.findAll(pageable);

        List<Employee> employees = page.getContent().stream()
                .map(employee -> mapper.map(employee, Employee.class))
                .toList();

        return new PaginationResult<>(employees, page.getTotalPages(), page.getTotalElements());
    }

    @Override
    public Employee update(Employee employee) {
        EmployeeEntity employeeSaved = repository.save(mapper.map(employee, EmployeeEntity.class));
        return mapper.map(employeeSaved, Employee.class);
    }

    @Override
    public void delete(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
    }
}
