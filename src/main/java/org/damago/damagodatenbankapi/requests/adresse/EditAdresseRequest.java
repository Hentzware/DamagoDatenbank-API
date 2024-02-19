package org.damago.damagodatenbankapi.requests.adresse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EditAdresseRequest {
    private String id;
    private String strasse;
    private String hausnummer;
    private String postleitzahl;
    private String ort;
    private String land;
}
