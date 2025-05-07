package co.com.olozano.api.supplier;

import co.com.olozano.api.dto.SupplierDto;
import co.com.olozano.api.mapper.EmployeeMapper;
import co.com.olozano.api.mapper.SupplierMapper;
import co.com.olozano.model.pagination.PaginationResult;
import co.com.olozano.model.supplier.Supplier;
import co.com.olozano.usecase.supplier.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SupplierRest {

    private final FindAllSuppliersUseCase findAllSuppliersUseCase;
    private final FindSuppliersUseCase findSuppliersUseCase;
    private final FindSupplierByIdUseCase findSupplierByIdUseCase;
    private final CreateSupplierUseCase createSupplierUseCase;
    private final UpdateSupplierUseCase updateSupplierUseCase;
    private final DeleteSupplierUseCase deleteSupplierUseCase;

    private final EmployeeMapper employeeMapper;
    private final SupplierMapper supplierMapper;

    @GetMapping("/list")
    public ResponseEntity<List<SupplierDto>> getAll() {

        List<Supplier> suppliers = findSuppliersUseCase.execute();

        if (suppliers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<SupplierDto> supplierDtos = suppliers.stream().map(supplierMapper::toDTO)
                .toList();

        return new ResponseEntity<>(supplierDtos, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<PaginationResult<SupplierDto>> getAllPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        page = page < 0 ? 0 : page;
        size = size <= 0 ? 10 : size;

        PaginationResult<Supplier> supplier = findAllSuppliersUseCase.execute(page, size);

        PaginationResult<SupplierDto> suppliers = new PaginationResult<>(
                supplier.data().stream().map(supplierMapper::toDTO).toList(),
                supplier.totalPages(),
                supplier.totalElements());

        return new ResponseEntity<>(suppliers, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<SupplierDto> create(
            @Valid @RequestBody SupplierDto supplierDto) {

        Supplier supplier = supplierMapper.toDomain(supplierDto);
        Supplier newSupplier = createSupplierUseCase.execute(supplier);

        return new ResponseEntity<>(supplierMapper.toDTO(newSupplier), HttpStatus.CREATED);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierDto> getById(
            @PathVariable("supplierId") UUID id
    ) {
        Supplier supplier = findSupplierByIdUseCase.execute(id);
        return new ResponseEntity<>(supplierMapper.toDTO(supplier), HttpStatus.OK);
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<SupplierDto> update(
            @PathVariable("supplierId") UUID id,
            @Valid @RequestBody SupplierDto supplierDto
    ) {

        Supplier supplier = updateSupplierUseCase.execute(id, supplierMapper.toDomain(supplierDto));

        return new ResponseEntity<>(supplierMapper.toDTO(supplier), HttpStatus.OK);
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> delete(@PathVariable("supplierId") UUID id) {

        deleteSupplierUseCase.execute(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
