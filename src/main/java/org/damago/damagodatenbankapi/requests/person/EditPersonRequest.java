package org.damago.damagodatenbankapi.requests.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class EditPersonRequest {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String nachname;

    @Getter @Setter
    private String vorname;

    @Getter @Setter
    private Date geburtsdatum;
}
