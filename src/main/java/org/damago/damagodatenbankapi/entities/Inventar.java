package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Inventar {
    @Id
    private String id;
    private String name;
    private int anzahl;
}
