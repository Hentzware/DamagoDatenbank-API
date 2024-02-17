package org.damago.damagodatenbankapi.requests.klasse;

import lombok.Getter;
import lombok.Setter;

public class AddKlasseRequest {
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String nr;
}
