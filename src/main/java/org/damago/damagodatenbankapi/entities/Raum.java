package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Raum {
    @Id
    private String id;
    private String name;
    private String nummer;
}
