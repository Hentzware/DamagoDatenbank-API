package org.damago.damagodatenbankapi.requests.personAdresse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPersonAdresseRequest {
    private String id;
    private String person_id;
    private String adresse_id;
}
