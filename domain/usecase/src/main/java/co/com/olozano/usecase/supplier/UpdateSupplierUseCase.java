package co.com.olozano.usecase.supplier;

import co.com.olozano.model.exceptions.NotFoundException;
import co.com.olozano.model.supplier.Supplier;
import co.com.olozano.model.supplier.gateways.SupplierRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateSupplierUseCase {
    private final SupplierRepository supplierRepository;

    public Supplier execute(UUID id, Supplier supplierData) {

        Supplier supplier = supplierRepository.findById(id);

        if (supplier == null) {
            throw new NotFoundException("Supplier With ID [" + id + "] not found");
        }

        supplier = supplier.toBuilder()
                .nit(supplierData.getNit())
                .name(supplierData.getName())
                .phoneNumber(supplierData.getPhoneNumber())
                .email(supplierData.getEmail())
                .address(supplierData.getAddress())
                .build();

        return supplierRepository.update(supplier);
    }
}
