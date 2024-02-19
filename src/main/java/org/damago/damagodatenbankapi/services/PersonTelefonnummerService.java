package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personTelefonnummer.*;
import org.damago.damagodatenbankapi.responses.PersonTelefonnummerResponse;

public interface PersonTelefonnummerService {
    PersonTelefonnummerResponse Add(AddPersonTelefonnummerRequest request);

    void Delete(DeletePersonTelefonnummerRequest request, boolean permanent);

    PersonTelefonnummerResponse Edit(EditPersonTelefonnummerRequest request);

    Iterable<PersonTelefonnummerResponse> Get(boolean deleted);

    PersonTelefonnummerResponse GetById(GetPersonTelefonnummerRequest request);

    Iterable<PersonTelefonnummerResponse> Search(SearchPersonTelefonnummerRequest request);
}
