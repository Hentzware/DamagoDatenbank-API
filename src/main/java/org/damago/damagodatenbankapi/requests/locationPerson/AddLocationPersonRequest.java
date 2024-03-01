package org.damago.damagodatenbankapi.requests.locationPerson;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddLocationPersonRequest {
    private String location_id;
    private String person_id;
}
