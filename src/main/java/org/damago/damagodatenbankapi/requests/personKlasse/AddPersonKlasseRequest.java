package org.damago.damagodatenbankapi.requests.personKlasse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPersonKlasseRequest {
    private String person_id;
    private String klasse_id;
}
