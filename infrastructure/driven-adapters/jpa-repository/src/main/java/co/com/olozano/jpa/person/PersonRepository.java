package co.com.olozano.jpa.person;

import co.com.olozano.jpa.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<PersonEntity/* change for adapter model */, UUID>,
        QueryByExampleExecutor<PersonEntity/* change for adapter model */> {
}
