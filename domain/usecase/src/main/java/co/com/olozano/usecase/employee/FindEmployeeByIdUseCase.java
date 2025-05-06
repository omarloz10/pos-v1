package co.com.olozano.usecase.employee;

import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.employee.gateways.EmployeeRepository;
import co.com.olozano.model.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FindEmployeeByIdUseCase {
    private final EmployeeRepository employeeRepository;

    public Employee execute(UUID id) {

        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new NotFoundException("Employee with ID [" + id + "] Not Found");
        }

        return employee;
    }
}
