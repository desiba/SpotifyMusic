package com.desmond.spotify.services;

import com.desmond.spotify.dto.AlbumDto;
import com.desmond.spotify.dto.SongDto;

import java.util.List;

public interface AlbumService {

    AlbumDto createAlbum(AlbumDto albumDto, String artisteId);

    List<AlbumDto> getAllAlbumByArtisteId(String artisteId);

}
