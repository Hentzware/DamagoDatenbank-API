package org.damago.damagodatenbankapi.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "Personen")
public class Person {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String nachname;

    @Getter
    @Setter
    private String vorname;

    @Getter
    @Setter
    private Date geburtsdatum;

    @Getter
    @Setter
    private String adresseId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AdresseId")
    @Getter
    @Setter
    private Adresse adresse;

    @Getter
    @Setter
    private String kontaktId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "KontaktId")
    @Getter
    @Setter
    private Kontakt kontakt;

    @Getter
    @Setter
    private String rolleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RolleId")
    @Getter
    @Setter
    private Rolle rolle;

    @Getter
    @Setter
    private String klasseId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "KlasseId")
    @Getter
    @Setter
    private Klasse klasse;

    @Getter
    @Setter
    private String standortId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StandortId")
    @Getter
    @Setter
    private Standort standort;
}
