package org.damago.damagodatenbankapi.requests.personPhone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPersonPhoneRequest {
    private String person_id;
    private String phone_id;
}