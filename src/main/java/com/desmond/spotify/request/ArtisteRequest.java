package com.desmond.spotify.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ArtisteRequest {

    @NotBlank
    private String fullName;

    @NotBlank
    private String stageName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
