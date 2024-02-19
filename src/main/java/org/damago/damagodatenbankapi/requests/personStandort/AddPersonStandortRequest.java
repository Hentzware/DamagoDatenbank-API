package org.damago.damagodatenbankapi.requests.personStandort;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddPersonStandortRequest {
    private String person_id;
    private String standort_id;
}
