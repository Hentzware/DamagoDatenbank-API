package org.damago.damagodatenbankapi.responses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class KlasseResponse {
    @Id
    private String id;
    private String name;
}
