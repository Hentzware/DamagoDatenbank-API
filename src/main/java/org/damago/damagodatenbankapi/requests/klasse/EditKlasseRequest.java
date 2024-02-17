package org.damago.damagodatenbankapi.requests.klasse;

import lombok.Getter;
import lombok.Setter;

public class EditKlasseRequest {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String nr;
}
