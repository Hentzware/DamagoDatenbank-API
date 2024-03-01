package org.damago.damagodatenbankapi.requests.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditModuleRequest {
    private String id;
    private String name;
    private String description;
}