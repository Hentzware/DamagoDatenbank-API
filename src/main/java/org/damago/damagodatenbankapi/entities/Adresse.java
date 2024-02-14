package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Adressen")
public class Adresse {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String strasse;

    @Getter
    @Setter
    private String hausnummer;

    @Getter
    @Setter
    private String postleitzahl;

    @Getter
    @Setter
    private String ort;

    @Getter
    @Setter
    private String land;

    @Getter @Setter
    private String personId;
}
