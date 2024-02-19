package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PersonAdresse {
    @Id
    private String id;
    private String person_id;
    private String adresse_id;
}
