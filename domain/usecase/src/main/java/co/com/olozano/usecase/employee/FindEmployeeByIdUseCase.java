package co.com.olozano.usecase.employee;

import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.employee.gateways.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FindEmployeeByIdUseCase {
    private final EmployeeRepository employeeRepository;

    public Employee execute(UUID id) {

        Employee employee = employeeRepository.findById(id);
        
        if (employee == null) {
            throw new RuntimeException("Employee Not Found");
        }

        return employee;
    }
}
