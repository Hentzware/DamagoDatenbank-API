package org.damago.damagodatenbankapi.requests.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddInventoryRequest {

    private String id;
    private String name;
    private int amount;
}
