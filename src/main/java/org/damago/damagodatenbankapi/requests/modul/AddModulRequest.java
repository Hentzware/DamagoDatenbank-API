package org.damago.damagodatenbankapi.requests.modul;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AddModulRequest {
    private String name;
    private String dauer;

}
