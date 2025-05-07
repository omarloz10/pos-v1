package co.com.olozano.usecase.supplier;

import co.com.olozano.model.exceptions.NotFoundException;
import co.com.olozano.model.supplier.Supplier;
import co.com.olozano.model.supplier.gateways.SupplierRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FindSupplierByIdUseCase {
    private final SupplierRepository supplierRepository;

    public Supplier execute(UUID id) {
        Supplier supplier = supplierRepository.findById(id);

        if (supplier == null) {
            throw new NotFoundException("Supplier With ID [" + id + "] not Found");
        }

        return supplier;
    }
}
