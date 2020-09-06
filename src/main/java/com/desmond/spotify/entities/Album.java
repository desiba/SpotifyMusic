package com.desmond.spotify.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.util.Date;


@Entity
@Table(name = "album", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "artisteId" })
})
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artisteId", nullable = false)
    public Artiste artisteId;

    @NotBlank
    @Size(max = 15)
    private String albumName;

    @NotBlank
    private Date dateReleased;

    @NotBlank
    private String producerName;

    @NotBlank
    @Size(max = 15)
    private String recordLabel;

    @NotBlank
    @Size(max = 15)
    private int trackCount;

    @NotBlank
    private String isSingle;

    @NotBlank
    private String isComplete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artiste getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(Artiste artisteId) {
        this.artisteId = artisteId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }
}
