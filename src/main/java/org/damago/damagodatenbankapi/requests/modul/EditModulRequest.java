package org.damago.damagodatenbankapi.requests.modul;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EditModulRequest {
    private String id;
    private String name;
    private String beschreibung;

}
