package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.phone.*;
import org.damago.damagodatenbankapi.responses.PhoneResponse;

public interface PhoneService {
    PhoneResponse Add(AddPhoneRequest request);

    void Delete(DeletePhoneRequest request, boolean permanent);

    PhoneResponse Edit(EditPhoneRequest request);

    Iterable<PhoneResponse> Get(boolean deleted);

    PhoneResponse GetById(GetPhoneRequest request);

    Iterable<PhoneResponse> Search(SearchPhoneRequest request);
}
