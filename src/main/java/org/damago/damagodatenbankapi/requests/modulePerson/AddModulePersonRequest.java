package org.damago.damagodatenbankapi.requests.modulePerson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddModulePersonRequest {
	private String module_id;
    private String person_id;
}