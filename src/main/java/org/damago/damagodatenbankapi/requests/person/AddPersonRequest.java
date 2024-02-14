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

    @Getter @Setter
    private String adresseId;

    @Getter @Setter
    private String kontaktId;

    @Getter @Setter
    private String rolleId;

    @Getter @Setter
    private String klasseId;

    @Getter @Setter
    private String standortId;
}
