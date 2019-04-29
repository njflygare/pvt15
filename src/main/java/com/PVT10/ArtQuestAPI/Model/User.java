package com.PVT10.ArtQuestAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class User {

    private final UUID id;
    @NotBlank
    private final String userName;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
