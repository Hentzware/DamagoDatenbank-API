package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Adresse {
    @Id
    private String id;
    private String strasse;
    private String hausnummer;
    private String postleitzahl;
    private String ort;
    private String land;
}
