package com.desmond.spotify.response;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

public class AlbumResponse {

    private String artisteId;

    private String albumName;

    private String dateReleased;

    private String producerName;

    private String recordLabel;

    public AlbumResponse(String artisteId, String albumName, String dateReleased, String producerName, String recordLabel) {
        this.artisteId = artisteId;
        this.albumName = albumName;
        this.dateReleased = dateReleased;
        this.producerName = producerName;
        this.recordLabel = recordLabel;
    }

    public String getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(String artisteId) {
        this.artisteId = artisteId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }
}
