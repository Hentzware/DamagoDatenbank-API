package org.damago.damagodatenbankapi.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class PersonResponse {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String nachname;

    @Getter @Setter
    private String vorname;

    @Getter @Setter
    private Date geburtsdatum;

    @Getter @Setter
    private KontaktResponse kontakt;

    @Getter @Setter
    private RolleResponse rolle;

    @Getter @Setter
    private AdresseResponse adresse;

    @Getter @Setter
    private KlasseResponse klasse;

    @Getter @Setter
    private StandortResponse standort;
}
