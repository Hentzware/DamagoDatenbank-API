package org.damago.damagodatenbankapi.requests.inventar;

import lombok.Getter;
import lombok.Setter;

public class EditInventarRequest {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int anzahl;
}
