package org.damago.damagodatenbankapi.requests.personAddress;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPersonAddressRequest {
	private String person_id;
    private String address_id;
}