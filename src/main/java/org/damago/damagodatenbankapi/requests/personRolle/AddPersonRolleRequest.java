package org.damago.damagodatenbankapi.requests.personRolle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPersonRolleRequest {
    private String personId;
    private String rolleId;
}
