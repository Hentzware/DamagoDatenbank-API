package org.damago.damagodatenbankapi.requests.personEmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPersonEmailRequest {
    private String id;
    private String person_id;
    private String email_id;
}
