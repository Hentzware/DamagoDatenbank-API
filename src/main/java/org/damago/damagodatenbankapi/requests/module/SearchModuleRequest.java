package org.damago.damagodatenbankapi.requests.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchModuleRequest {
    private String name;
    private String description;
}