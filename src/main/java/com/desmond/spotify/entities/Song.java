package com.desmond.spotify.entities;

import com.desmond.spotify.entities.Album;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;


@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "album_id", nullable = true)
    private String albumId;

    @NotBlank
    @Column(name = "song_name")
    private String fileName;

    @NotBlank
    @Column(name = "song_url")
    private String fileUri;

    @NotBlank
    @Column(name = "song_file_type")
    private String fileType;

    @NotBlank
    @Column(name = "song_size")
    private long fileSize;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
