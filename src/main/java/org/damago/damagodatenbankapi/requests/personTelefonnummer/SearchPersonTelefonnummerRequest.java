package org.damago.damagodatenbankapi.requests.personTelefonnummer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonTelefonnummerRequest {
    private String personId;
    private String telefonnummerId;
}
