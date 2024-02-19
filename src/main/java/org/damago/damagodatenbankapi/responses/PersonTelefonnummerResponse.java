package org.damago.damagodatenbankapi.responses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonTelefonnummerResponse {
    @Id
    private String id;
    private String person_id;
    private String telefonnummer_id;
}
