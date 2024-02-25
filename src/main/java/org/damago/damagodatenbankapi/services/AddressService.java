package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.address.*;
import org.damago.damagodatenbankapi.responses.AddressResponse;

public interface AddressService {
    AddressResponse Add(AddAddressRequest request);

    void Delete(DeleteAddressRequest request, boolean permanent);

    AddressResponse Edit(EditAddressRequest request);

    Iterable<AddressResponse> Get(boolean deleted);

    AddressResponse GetById(GetAddressRequest request);

    Iterable<AddressResponse> Search(SearchAdresseRequest request);
}
