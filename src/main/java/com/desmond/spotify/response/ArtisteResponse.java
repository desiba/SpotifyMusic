package com.desmond.spotify.response;

import javax.validation.constraints.NotBlank;

public class ArtisteResponse {

    private String artisteId;

    private String fullName;

    private String stageName;

    public ArtisteResponse(String artisteId, String fullName, String stageName) {
        this.artisteId = artisteId;
        this.fullName = fullName;
        this.stageName = stageName;
    }

    public String getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(String artisteId) {
        this.artisteId = artisteId;
    }

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
