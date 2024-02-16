package org.damago.damagodatenbankapi.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
public class Person {
    @Id
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
}
