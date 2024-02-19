package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.personEmail.*;
import org.damago.damagodatenbankapi.responses.PersonEmailResponse;

public interface PersonEmailService {
    PersonEmailResponse Add(AddPersonEmailRequest request);

    void Delete(DeletePersonEmailRequest request, boolean permanent);

    PersonEmailResponse Edit(EditPersonEmailRequest request);

    Iterable<PersonEmailResponse> Get(boolean deleted);

    PersonEmailResponse GetById(GetPersonEmailRequest request);

    Iterable<PersonEmailResponse> Search(SearchPersonEmailRequest request);
}
