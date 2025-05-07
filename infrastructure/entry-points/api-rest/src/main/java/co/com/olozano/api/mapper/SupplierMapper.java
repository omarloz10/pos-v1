package co.com.olozano.api.mapper;

import co.com.olozano.api.dto.SupplierDto;
import co.com.olozano.model.supplier.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Supplier toDomain(SupplierDto supplierDto);

    SupplierDto toDTO(Supplier supplier);
}
