package org.damago.damagodatenbankapi.requests.room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRoomRequest {
    private String name;
    private String nr;
}