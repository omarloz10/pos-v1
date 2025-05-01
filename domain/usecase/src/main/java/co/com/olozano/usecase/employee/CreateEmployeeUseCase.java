package co.com.olozano.usecase.employee;

import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.employee.gateways.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public Employee execute(Employee employee) {
        return employeeRepository.save(employee);
    }
}
