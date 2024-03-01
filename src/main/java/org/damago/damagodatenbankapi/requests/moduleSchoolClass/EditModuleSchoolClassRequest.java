package org.damago.damagodatenbankapi.requests.moduleSchoolClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditModuleSchoolClassRequest {
    private String id;
    private String module_id;
    private String school_class_id;
}