package org.damago.damagodatenbankapi.requests.personRolle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonRolleRequest {
    private String person_id;
    private String rolle_id;
}
