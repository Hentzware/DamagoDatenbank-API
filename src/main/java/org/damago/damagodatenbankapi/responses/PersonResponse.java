package org.damago.damagodatenbankapi.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class PersonResponse {
    private String id;
    private String nachname;
    private String vorname;
    private Date geburtsdatum;
}
