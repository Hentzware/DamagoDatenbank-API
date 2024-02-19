package org.damago.damagodatenbankapi.requests.personTelefonnummer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPersonTelefonnummerRequest {
    private String person_id;
    private String telefonnummer_id;
}
