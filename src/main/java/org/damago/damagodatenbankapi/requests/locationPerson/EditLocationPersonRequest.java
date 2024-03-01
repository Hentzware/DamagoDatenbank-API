package org.damago.damagodatenbankapi.requests.locationPerson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditLocationPersonRequest {
    private String id;
    private String person_id;
    private String location_id;
}
