package org.damago.damagodatenbankapi.requests.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditAddressRequest {
    private String id;
    private String street;
    private String house_number;
    private String postal_code;
    private String location;
    private String country;
}