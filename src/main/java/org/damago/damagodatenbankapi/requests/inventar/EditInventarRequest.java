package org.damago.damagodatenbankapi.requests.inventar;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EditInventarRequest {
    private String id;
    private String name;
    private int anzahl;
}
