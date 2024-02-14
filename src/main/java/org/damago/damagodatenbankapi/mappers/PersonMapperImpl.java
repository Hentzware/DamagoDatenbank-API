package org.damago.damagodatenbankapi.mappers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

public class PersonMapperImpl implements PersonMapper {
    @Override
    public PersonResponse mapToPersonResponse(Person person) {
        PersonResponse personResponse = new PersonResponse();

        personResponse.setId(person.getId());
        personResponse.setNachname(person.getNachname());
        personResponse.setVorname(person.getVorname());
        personResponse.setGeburtsdatum(person.getGeburtsdatum());

        // personResponse.setAdresse(person.getAdresse());
        // personResponse.setKontakt(person.getKontakt());
        // personResponse.setKlasse(person.getKlasse());
        // personResponse.setStandort(person.getStandort());

        return personResponse;
    }

    @Override
    public Person mapToPerson(AddPersonRequest addPersonRequest) {
        Person person = new Person();

        person.setNachname(addPersonRequest.getNachname());
        person.setVorname(addPersonRequest.getVorname());
        person.setGeburtsdatum(addPersonRequest.getGeburtsdatum());

        return person;
    }

    @Override
    public Person mapToPerson(EditPersonRequest editPersonRequest) {
        return null;
    }
}
