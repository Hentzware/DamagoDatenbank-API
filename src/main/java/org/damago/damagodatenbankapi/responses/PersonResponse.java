package org.damago.damagodatenbankapi.responses;

import jakarta.persistence.Column;
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
    private String nachname;
    private String vorname;
    private Date geburtsdatum;
}
