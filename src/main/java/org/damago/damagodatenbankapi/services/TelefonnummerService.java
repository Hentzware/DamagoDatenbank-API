package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.telefonnummer.AddTelefonnummerRequest;
import org.damago.damagodatenbankapi.requests.telefonnummer.DeleteTelefonnummerRequest;
import org.damago.damagodatenbankapi.requests.telefonnummer.EditTelefonnummerRequest;
import org.damago.damagodatenbankapi.requests.telefonnummer.GetTelefonnummerRequest;
import org.damago.damagodatenbankapi.responses.TelefonnummerResponse;

public interface TelefonnummerService {
    TelefonnummerResponse Add(AddTelefonnummerRequest request);

    void Delete(DeleteTelefonnummerRequest request, boolean permanent);

    TelefonnummerResponse Edit(EditTelefonnummerRequest request);

    Iterable<TelefonnummerResponse> Get(boolean deleted);

    TelefonnummerResponse GetById(GetTelefonnummerRequest request);

    Iterable<TelefonnummerResponse> Search(String telefonnummer);
}
