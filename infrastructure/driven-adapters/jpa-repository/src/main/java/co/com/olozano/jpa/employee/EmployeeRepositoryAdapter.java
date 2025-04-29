package co.com.olozano.jpa.employee;

import co.com.olozano.jpa.entity.EmployeeEntity;
import co.com.olozano.jpa.helper.AdapterOperations;
import co.com.olozano.model.employee.Employee;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EmployeeRepositoryAdapter extends AdapterOperations<Employee/* change for domain model */, EmployeeEntity/* change for adapter model */, UUID, EmployeeRepository>
// implements ModelRepository from domain
    implements co.com.olozano.model.employee.gateways.EmployeeRepository
{

    public EmployeeRepositoryAdapter(EmployeeRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Employee.class/* change for domain model */));
    }
}
