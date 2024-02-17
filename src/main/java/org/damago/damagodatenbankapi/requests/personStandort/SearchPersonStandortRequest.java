package org.damago.damagodatenbankapi.requests.personStandort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonStandortRequest {
    private String personId;
    private String standortId;
}
