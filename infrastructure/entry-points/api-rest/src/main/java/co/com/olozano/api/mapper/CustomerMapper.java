package co.com.olozano.api.mapper;

import co.com.olozano.api.dto.CustomerDto;
import co.com.olozano.model.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", source = "customerId")
    @Mapping(target = "person.id", source = "personId")
    @Mapping(target = "person.name", source = "name")
    @Mapping(target = "person.lastname", source = "lastname")
    @Mapping(target = "person.age", source = "age")
    @Mapping(target = "person.documentType", source = "documentType")
    @Mapping(target = "person.documentNumber", source = "documentNumber")
    @Mapping(target = "person.numberPhone", source = "numberPhone")
    @Mapping(target = "person.email", source = "email")
    @Mapping(target = "person.address", source = "address")
    @Mapping(target = "person.gender", source = "gender")
    @Mapping(target = "person.birthdate", source = "birthdate")
    @Mapping(target = "deleted",ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Customer toDomain(CustomerDto customerDto);

    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "personId", source = "person.id")
    @Mapping(target = "name", source = "person.name")
    @Mapping(target = "lastname", source = "person.lastname")
    @Mapping(target = "age", source = "person.age")
    @Mapping(target = "documentType", source = "person.documentType")
    @Mapping(target = "documentNumber", source = "person.documentNumber")
    @Mapping(target = "numberPhone", source = "person.numberPhone")
    @Mapping(target = "email", source = "person.email")
    @Mapping(target = "address", source = "person.address")
    @Mapping(target = "gender", source = "person.gender")
    @Mapping(target = "birthdate", source = "person.birthdate")
    CustomerDto toDTO(Customer customer);
}
