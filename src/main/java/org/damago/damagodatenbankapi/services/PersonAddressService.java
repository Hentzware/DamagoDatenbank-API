package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personAddress.*;
import org.damago.damagodatenbankapi.responses.PersonAddressResponse;

public interface PersonAddressService {
    PersonAddressResponse Add(AddPersonAddressRequest request);

    void Delete(DeletePersonAddressRequest request, boolean permanent);

    PersonAddressResponse Edit(EditPersonAddressRequest request);

    Iterable<PersonAddressResponse> Get(boolean deleted);

    PersonAddressResponse GetById(GetPersonAddressRequest request);

    Iterable<PersonAddressResponse> Search(SearchPersonAddressRequest request);
}
