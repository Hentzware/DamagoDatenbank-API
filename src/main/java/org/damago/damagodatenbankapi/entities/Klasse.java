package org.damago.damagodatenbankapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

public class Klasse {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;
}
