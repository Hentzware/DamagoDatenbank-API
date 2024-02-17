package org.damago.damagodatenbankapi.requests.inventar;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddInventarRequest {

    private String id;
    private String name;
    private int anzahl;
}
