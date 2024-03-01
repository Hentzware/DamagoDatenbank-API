package org.damago.damagodatenbankapi.responses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ModulePersonResponse {
    @Id
    private String id;
    private String module_id;
    private String person_id;
}
