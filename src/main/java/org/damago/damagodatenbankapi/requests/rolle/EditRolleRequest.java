package org.damago.damagodatenbankapi.requests.rolle;

import lombok.Getter;
import lombok.Setter;

public class EditRolleRequest {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;
}
