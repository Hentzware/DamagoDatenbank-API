package org.damago.damagodatenbankapi.requests.personRolle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPersonRolleRequest {
    private String id;
    private String person_id;
    private String rolle_id;
}
