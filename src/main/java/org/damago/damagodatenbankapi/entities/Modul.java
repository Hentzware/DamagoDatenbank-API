package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Modul {
    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter String dauer;
}
