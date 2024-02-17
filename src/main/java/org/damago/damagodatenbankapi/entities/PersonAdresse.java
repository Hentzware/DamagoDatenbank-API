package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class PersonAdresse {
    @Id @Getter @Setter
    private String id;

    @Getter @Setter
    private String personId;

    @Getter @Setter
    private String adresseId;
}
