package co.com.olozano.usecase.employee;

import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.employee.gateways.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
public class UpdateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public Employee execute(UUID id, Employee employeeData) {

        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee not Found");
        }

        employee = employee.toBuilder()
                .name(employeeData.getName())
                .lastname(employeeData.getLastname())
                .documentType(employeeData.getDocumentType())
                .documentNumber(employeeData.getDocumentNumber())
                .numberPhone(employeeData.getNumberPhone())
                .email(employeeData.getEmail())
                .address(employeeData.getAddress())
                .gender(employeeData.getGender())
                .birthdate(employeeData.getBirthdate())
                .entryDate(employeeData.getEntryDate())
                .build();


        return employeeRepository.save(employee);
    }
}
