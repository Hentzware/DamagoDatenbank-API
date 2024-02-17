package org.damago.damagodatenbankapi.requests.personStandort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPersonStandortRequest {
    private String id;
    private String personId;
    private String standortId;
}
