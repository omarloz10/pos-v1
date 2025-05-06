package co.com.olozano.model.employee.gateways;

import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository {
    PaginationResult<Employee> findCustomers(PaginationQuery paginationQuery);

    List<Employee> findAll();

    Employee findById(UUID id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void delete(Employee employee);
}
