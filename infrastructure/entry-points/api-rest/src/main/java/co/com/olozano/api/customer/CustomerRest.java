package co.com.olozano.api.customer;

import co.com.olozano.api.dto.CustomerDto;
import co.com.olozano.api.mapper.CustomerMapper;
import co.com.olozano.model.customer.Customer;
import co.com.olozano.model.pagination.PaginationResult;
import co.com.olozano.usecase.customer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CustomerRest {

    private final FindAllCustomersUseCase findAllCustomersUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    private final CustomerMapper customerMapper;

    @GetMapping("/")
    public ResponseEntity<PaginationResult<CustomerDto>> getAllPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        page = page < 0 ? 0 : page;
        size = size <= 0 ? 10 : size;

        PaginationResult<Customer> customer = findAllCustomersUseCase.execute(page, size);

        PaginationResult<CustomerDto> customerDto = new PaginationResult<>(
                customer.data().stream().map(customerMapper::toDTO).toList(),
                customer.totalPages(),
                customer.totalElements());

        return new ResponseEntity<>(customerDto, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<CustomerDto> create(
            @Valid @RequestBody CustomerDto customerDto) {

        Customer customer = customerMapper.toDomain(customerDto);
        Customer newCustomer = createCustomerUseCase.execute(customer);

        return new ResponseEntity<>(customerMapper.toDTO(newCustomer), HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getById(
            @PathVariable("customerId") UUID id
    ) {
        Customer customer = findCustomerByIdUseCase.execute(id);
        return new ResponseEntity<>(customerMapper.toDTO(customer), HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> update(
            @PathVariable("customerId") UUID id,
            @Valid @RequestBody CustomerDto customerDto
    ) {

        Customer customer = updateCustomerUseCase.execute(id, customerMapper.toDomain(customerDto));

        return new ResponseEntity<>(customerMapper.toDTO(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable("customerId") UUID id) {

        deleteCustomerUseCase.execute(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
