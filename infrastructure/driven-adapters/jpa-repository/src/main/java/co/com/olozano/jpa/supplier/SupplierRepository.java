package co.com.olozano.jpa.supplier;

import co.com.olozano.jpa.entity.SupplierEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface SupplierRepository extends
        PagingAndSortingRepository<SupplierEntity, UUID>,
        CrudRepository<SupplierEntity/* change for adapter model */, UUID>,
        QueryByExampleExecutor<SupplierEntity/* change for adapter model */> {
}
