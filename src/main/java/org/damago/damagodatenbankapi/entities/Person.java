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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AdresseId")
    @Getter
    @Setter
    private Adresse adresse;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "KontaktId")
    @Getter
    @Setter
    private Kontakt kontakt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RolleId")
    @Getter
    @Setter
    private Rolle rolle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "KlasseId")
    @Getter
    @Setter
    private Klasse klasse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StandortId")
    @Getter
    @Setter
    private Standort standort;
}
