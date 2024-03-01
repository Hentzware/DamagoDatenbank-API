package org.damago.damagodatenbankapi.responses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class PersonResponse {
    @Id
    private String id;
    private String last_name;
    private String first_name;
    private Date birthdate;
}
