package org.damago.damagodatenbankapi.requests.raum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditRaumRequest {
    private String id;
    private String name;
    private String nr;
}
