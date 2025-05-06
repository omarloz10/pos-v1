package co.com.olozano.usecase.employee;

import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.employee.gateways.EmployeeRepository;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAllEmployeesUseCase {
    private final EmployeeRepository employeeRepository;

    public PaginationResult<Employee> execute(int page, int size) {

        return employeeRepository.findCustomers(new PaginationQuery(page, size));
    }
}
