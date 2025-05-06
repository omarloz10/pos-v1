package co.com.olozano.api.mapper;

import co.com.olozano.api.dto.EmployeeDto;
import co.com.olozano.model.employee.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Employee toDomain(EmployeeDto employeeDto);


    EmployeeDto toDTO(Employee employee);
}
