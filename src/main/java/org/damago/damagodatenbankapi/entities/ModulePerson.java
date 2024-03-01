package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ModulePerson {
    @Id
    private String id;
    private String module_id;
    private String person_id;
}