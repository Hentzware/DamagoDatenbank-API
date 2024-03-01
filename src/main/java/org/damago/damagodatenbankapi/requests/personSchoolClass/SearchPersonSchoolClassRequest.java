package org.damago.damagodatenbankapi.requests.personSchoolClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonSchoolClassRequest {
    private String person_id;
    private String school_class_id;
}