package org.damago.damagodatenbankapi.responses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LocationSchoolClassResponse {
    @Id
    private String id;
    private String location_id;
    private String school_class_id;
}
