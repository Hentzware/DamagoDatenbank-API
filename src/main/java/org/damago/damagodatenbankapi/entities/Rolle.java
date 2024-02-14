package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NamedStoredProcedureQuery(
        name = "spRolesGet",
        procedureName = "sp_Roles_Get"
)
public class Rolle {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;
}
