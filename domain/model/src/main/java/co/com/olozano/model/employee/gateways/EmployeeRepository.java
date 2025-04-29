package co.com.olozano.model.employee.gateways;

import co.com.olozano.model.employee.Employee;

public interface EmployeeRepository {

    Employee save(Employee employee);
}
