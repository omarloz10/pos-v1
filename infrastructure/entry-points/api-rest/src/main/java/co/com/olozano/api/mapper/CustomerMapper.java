package co.com.olozano.api.mapper;

import co.com.olozano.api.dto.CustomerDto;
import co.com.olozano.model.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Customer toDomain(CustomerDto customerDto);


    CustomerDto toDTO(Customer customer);
}
