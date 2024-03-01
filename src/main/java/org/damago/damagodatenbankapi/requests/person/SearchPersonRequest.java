package org.damago.damagodatenbankapi.requests.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchPersonRequest {
    private String last_name;
    private String first_name;
    private Date birthdate;
}
