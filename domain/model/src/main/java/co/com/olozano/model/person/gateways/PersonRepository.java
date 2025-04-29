package co.com.olozano.model.person.gateways;

import co.com.olozano.model.person.Person;

public interface PersonRepository {

    Person save(Person person);
}
