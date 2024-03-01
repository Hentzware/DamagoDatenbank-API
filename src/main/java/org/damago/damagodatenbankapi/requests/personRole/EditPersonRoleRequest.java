package org.damago.damagodatenbankapi.requests.personRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPersonRoleRequest {
    private String id;
    private String person_id;
    private String role_id;
}