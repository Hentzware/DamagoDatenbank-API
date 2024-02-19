package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.klasse.*;
import org.damago.damagodatenbankapi.responses.KlasseResponse;

public interface KlasseService {
    KlasseResponse Add(AddKlasseRequest request);

    void Delete(DeleteKlasseRequest request, boolean permanent);

    KlasseResponse Edit(EditKlasseRequest request);

    Iterable<KlasseResponse> Get(boolean deleted);

    KlasseResponse GetById(GetKlasseRequest request);

    Iterable<KlasseResponse> Search(SearchKlasseRequest request);
}
