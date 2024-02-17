package org.damago.damagodatenbankapi.requests.personEmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonEmailRequest {
    private String personId;
    private String emailId;
}
