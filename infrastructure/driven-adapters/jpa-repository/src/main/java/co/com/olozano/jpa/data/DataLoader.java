package co.com.olozano.jpa.data;

import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.customer.gateways.CustomerRepository;
import co.com.olozano.model.employee.Employee;
import co.com.olozano.model.employee.gateways.EmployeeRepository;
import co.com.olozano.model.person.Person;
import co.com.olozano.model.person.gateways.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Configuration
public class DataLoader {
//
//    @Bean
//    public CommandLineRunner loadData(PersonRepository personRepository,
//                                      EmployeeRepository employeeRepository,
//                                      CustomerRepository customerRepository) {
//        return args -> {
//            // Crear la persona base
//            Person person = new Person();
//            person.setName("Carlos");
//            person.setLastname("Ramírez");
//            person.setDocumentNumber("1234567890");
//            person.setDocumentType("CC");
//            person.setEmail("carlos.ramirez@example.com");
//            person.setNumberPhone("3001112233");
//            person.setBirthdate(LocalDate.of(1985, 4, 10));
//            person.setAge((int) ChronoUnit.YEARS.between(person.getBirthdate(), LocalDate.now()));
//            person.setCreatedAt(LocalDateTime.now());
//            person.setUpdatedAt(LocalDateTime.now());
//
//            // Guardar la persona y obtenerla con ID
//            Person savedPerson = personRepository.save(person);
//
//            // Asociar como empleado
//            Employee employee = new Employee();
//            employee.setPerson(savedPerson);
//            employee.setEntryDate(LocalDate.of(2023, 5, 1));
//            employeeRepository.save(employee);
//
//            // Asociar como cliente
//            Customer customer = new Customer();
//            customer.setPerson(savedPerson);
//            customerRepository.save(customer);
//
//            System.out.println("Persona registrada como cliente y empleado exitosamente.");
//        };
//    }
}
