package org.damago.damagodatenbankapi.requests.personKlasse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonKlasseRequest {
    private String personId;
    private String klasseId;
}
