package co.com.olozano.api.employee;

import co.com.olozano.api.dto.EmployeeDto;
import co.com.olozano.api.mapper.EmployeeMapper;
import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.pagination.PaginationResult;
import co.com.olozano.usecase.employee.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeRest {

    private final FindAllEmployeesUseCase findAllEmployeesUseCase;
    private final FindEmployeeByIdUseCase findEmployeeByIdUseCase;
    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    private final EmployeeMapper employeeMapper;

    @GetMapping("/")
    public ResponseEntity<PaginationResult<EmployeeDto>> getAllPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        page = page < 0 ? 0 : page;
        size = size <= 0 ? 10 : size;

        PaginationResult<Employee> employee = findAllEmployeesUseCase.execute(page, size);

        PaginationResult<EmployeeDto> employeeDto = new PaginationResult<>(
                employee.data().stream().map(employeeMapper::toDTO).toList(),
                employee.totalPages(),
                employee.totalElements());

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> create(
            @RequestBody EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toDomain(employeeDto);
        Employee newEmployee = createEmployeeUseCase.execute(employee);

        return new ResponseEntity<>(employeeMapper.toDTO(newEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getById(
            @PathVariable("employeeId") UUID id
    ) {
        Employee employee = findEmployeeByIdUseCase.execute(id);
        return new ResponseEntity<>(employeeMapper.toDTO(employee), HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> update(
            @PathVariable("employeeId") UUID id,
            @RequestBody EmployeeDto employeeDto
    ) {

        Employee employee = updateEmployeeUseCase.execute(id, employeeMapper.toDomain(employeeDto));

        return new ResponseEntity<>(employeeMapper.toDTO(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable("employeeId") UUID id) {

        deleteEmployeeUseCase.execute(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
