package org.damago.damagodatenbankapi.mappers;

import org.damago.damagodatenbankapi.entities.Person;
import org.damago.damagodatenbankapi.requests.person.AddPersonRequest;
import org.damago.damagodatenbankapi.requests.person.EditPersonRequest;
import org.damago.damagodatenbankapi.responses.PersonResponse;

public interface PersonMapper {
    PersonResponse mapToPersonResponse(Person person);
    Person mapToPerson(AddPersonRequest addPersonRequest);
    Person mapToPerson(EditPersonRequest editPersonRequest);
}
