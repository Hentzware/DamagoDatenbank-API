package org.damago.damagodatenbankapi.requests.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchInventoryRequest {
    private String name;
    private int amount;
}
