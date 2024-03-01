package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonAddress {
    @Id
    private String id;
    private String person_id;
    private String address_id;
}