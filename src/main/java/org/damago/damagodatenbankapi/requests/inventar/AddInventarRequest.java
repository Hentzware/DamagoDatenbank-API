package org.damago.damagodatenbankapi.requests.inventar;

import lombok.Getter;
import lombok.Setter;

public class AddInventarRequest {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int anzahl;
}
