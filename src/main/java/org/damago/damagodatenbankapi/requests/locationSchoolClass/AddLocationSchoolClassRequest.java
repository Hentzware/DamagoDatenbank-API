package org.damago.damagodatenbankapi.requests.locationSchoolClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddLocationSchoolClassRequest {
    private String location_id;
    private String school_class_id;
}
