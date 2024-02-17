package org.damago.damagodatenbankapi.requests.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class EditPersonRequest {
    private String id;
    private String nachname;
    private String vorname;
    private Date geburtsdatum;
}
