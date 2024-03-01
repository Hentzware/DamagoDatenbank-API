package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonSchoolClass {
    @Id
    private String id;
    private String person_id;
    private String school_class_id;
}