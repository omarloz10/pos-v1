package co.com.olozano.usecase.supplier;

import co.com.olozano.model.supplier.Supplier;
import co.com.olozano.model.supplier.gateways.SupplierRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateSupplierUseCase {
    private final SupplierRepository supplierRepository;

    public Supplier execute(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
