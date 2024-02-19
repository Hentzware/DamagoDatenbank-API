package org.damago.damagodatenbankapi.requests.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditEmailRequest {
    private String id;
    private String email;
}
