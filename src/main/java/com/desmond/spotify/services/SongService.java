package com.desmond.spotify.services;

import com.desmond.spotify.dto.SongDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface SongService {

    String storeSong(MultipartFile file);

    SongDto createSong(SongDto song);

    String fetchSongsByName(String songName);
    String fetchSongsByArtiste(String artiseName);
    String fetchSongsByAlbum(String albumName);
    String fetchAllSongs();
}
