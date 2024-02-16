package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Adresse {
    @Id
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
}
