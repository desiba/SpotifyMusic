package com.desmond.spotify.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ArtisteDto implements Serializable {


    private String artisteId;

    private String fullName;

    private String stageName;

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
