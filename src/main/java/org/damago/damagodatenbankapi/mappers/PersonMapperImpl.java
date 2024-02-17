package org.damago.damagodatenbankapi.mappers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

import java.util.ArrayList;
import java.util.List;

public class PersonMapperImpl implements PersonMapper {
    @Override
    public PersonResponse mapToPersonResponse(Person person) {
        PersonResponse personResponse = new PersonResponse();

        personResponse.setId(person.getId());
        personResponse.setNachname(person.getNachname());
        personResponse.setVorname(person.getVorname());
        personResponse.setGeburtsdatum(person.getGeburtsdatum());

        return personResponse;
    }

    @Override
    public Iterable<PersonResponse> mapToPersonResponses(Iterable<Person> persons) {
        List<PersonResponse> personResponses = new ArrayList<>();

        for (Person p : persons) {
            personResponses.add(mapToPersonResponse(p));
        }

        return personResponses;
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
        Person person = new Person();

        person.setId(editPersonRequest.getId());
        person.setNachname(editPersonRequest.getNachname());
        person.setVorname(editPersonRequest.getVorname());
        person.setGeburtsdatum(editPersonRequest.getGeburtsdatum());

        return person;
    }
}
