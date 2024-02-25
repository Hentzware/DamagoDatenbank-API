package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address {
    @Id
    private String id;
    private String street;
    private String house_number;
    private String postal_code;
    private String location;
    private String country;
}
