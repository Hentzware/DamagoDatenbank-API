package org.damago.damagodatenbankapi.requests.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchPersonRequest {
    private String nachname;
    private String vorname;
    private Date geburtsdatum;
}
