package co.com.olozano.jpa.person;

import co.com.olozano.jpa.entity.PersonEntity;
import co.com.olozano.jpa.helper.AdapterOperations;
import co.com.olozano.model.person.Person;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PersonRepositoryAdapter extends AdapterOperations<Person/* change for domain model */, PersonEntity/* change for adapter model */, UUID, PersonRepository>
// implements ModelRepository from domain
    implements co.com.olozano.model.person.gateways.PersonRepository
{

    public PersonRepositoryAdapter(PersonRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Person.class/* change for domain model */));
    }
}
