package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.adresse.*;
import org.damago.damagodatenbankapi.responses.AdresseResponse;

public interface AdresseService {
    AdresseResponse Add(AddAdresseRequest request);

    void Delete(DeleteAdresseRequest request, boolean permanent);

    AdresseResponse Edit(EditAdresseRequest request);

    Iterable<AdresseResponse> Get(boolean deleted);

    AdresseResponse GetById(GetAdresseRequest request);

    Iterable<AdresseResponse> Search(SearchAdresseRequest request);
}
