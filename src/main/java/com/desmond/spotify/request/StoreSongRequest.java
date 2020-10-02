package com.desmond.spotify.request;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class StoreSongRequest {

    @NotBlank
    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
