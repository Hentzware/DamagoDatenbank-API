package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.requests.email.*;
import org.damago.damagodatenbankapi.responses.EmailResponse;

public interface EmailService {
    EmailResponse Add(AddEmailRequest request);

    void Delete(DeleteEmailRequest request, boolean permanent);

    EmailResponse Edit(EditEmailRequest request);

    Iterable<EmailResponse> Get(boolean deleted);

    EmailResponse GetById(GetEmailRequest request);

    Iterable<EmailResponse> Search(SearchEmailRequest request);
}
