package org.damago.damagodatenbankapi.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Person {
    @Id
    private String id;
    private String last_name;
    private String first_name;
    private Date birthdate;
}
