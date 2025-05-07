package co.com.olozano.jpa.supplier;

import co.com.olozano.jpa.entity.SupplierEntity;
import co.com.olozano.jpa.helper.AdapterOperations;
import co.com.olozano.model.pagination.PaginationQuery;
import co.com.olozano.model.pagination.PaginationResult;
import co.com.olozano.model.supplier.Supplier;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SupplierRepositoryAdapter extends AdapterOperations<Supplier/* change for domain model */, SupplierEntity/* change for adapter model */, UUID, SupplierRepository>
// implements ModelRepository from domain
        implements co.com.olozano.model.supplier.gateways.SupplierRepository {

    public SupplierRepositoryAdapter(SupplierRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Supplier.class/* change for domain model */));
    }

    @Override
    public PaginationResult<Supplier> findSuppliers(PaginationQuery paginationQuery) {
        Pageable pageable = PageRequest.of(paginationQuery.getPage(), paginationQuery.getSize(), Sort.by("createdAt").descending());

        Page<SupplierEntity> page = repository.findAll(pageable);

        List<Supplier> suppliers = page.getContent().stream()
                .map(supplier -> mapper.map(supplier, Supplier.class))
                .toList();

        return new PaginationResult<>(suppliers, page.getTotalPages(), page.getTotalElements());
    }

    @Override
    public Supplier update(Supplier supplier) {
        SupplierEntity supplierSaved = repository.save(mapper.map(supplier, SupplierEntity.class));
        return mapper.map(supplierSaved, Supplier.class);
    }

    @Override
    public void delete(Supplier supplier) {
        repository.save(mapper.map(supplier, SupplierEntity.class));

    }
}
