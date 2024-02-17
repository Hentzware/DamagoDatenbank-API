package org.damago.damagodatenbankapi.requests.inventar;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchInventarRequest {
    private String name;
    private int anzahl;
}
