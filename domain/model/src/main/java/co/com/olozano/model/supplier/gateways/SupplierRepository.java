package co.com.olozano.model.supplier.gateways;

import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import co.com.olozano.model.supplier.Supplier;

import java.util.List;
import java.util.UUID;

public interface SupplierRepository {
    PaginationResult<Supplier> findSuppliers(PaginationQuery paginationQuery);

    List<Supplier> findAll();

    Supplier findById(UUID id);

    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(Supplier supplier);
}
