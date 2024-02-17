package org.damago.damagodatenbankapi.requests.adresse;

import lombok.Getter;
import lombok.Setter;

public class AddAdresseRequest {
    @Getter @Setter
    private String strasse;

    @Getter @Setter
    private String hausnummer;

    @Getter @Setter
    private String postleitzahl;

    @Getter @Setter
    private String ort;

    @Getter @Setter
    private String land;
}
