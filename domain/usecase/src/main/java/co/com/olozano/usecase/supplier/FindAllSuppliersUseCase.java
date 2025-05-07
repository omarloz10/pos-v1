package co.com.olozano.usecase.supplier;

import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import co.com.olozano.model.supplier.Supplier;
import co.com.olozano.model.supplier.gateways.SupplierRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAllSuppliersUseCase {
    private final SupplierRepository supplierRepository;

    public PaginationResult<Supplier> execute(int page, int size) {
        return supplierRepository.findSuppliers(new PaginationQuery(page, size));
    }
}
