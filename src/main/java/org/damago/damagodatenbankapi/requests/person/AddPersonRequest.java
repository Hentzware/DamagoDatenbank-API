package org.damago.damagodatenbankapi.requests.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class AddPersonRequest {
    @Getter @Setter
    private String nachname;

    @Getter @Setter
    private String vorname;

    @Getter @Setter
    private Date geburtsdatum;
}
