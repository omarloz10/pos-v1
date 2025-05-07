package co.com.olozano.usecase.supplier;

import co.com.olozano.model.supplier.Supplier;
import co.com.olozano.model.supplier.gateways.SupplierRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindSuppliersUseCase {
    private final SupplierRepository supplierRepository;

    public List<Supplier> execute() {
        return supplierRepository.findAll();
    }
}
