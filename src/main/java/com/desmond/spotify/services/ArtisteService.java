package com.desmond.spotify.services;


import com.desmond.spotify.dto.ArtisteDto;
import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.entities.Artiste;

import java.util.List;

public interface ArtisteService {
    ArtisteDto addArtiste(ArtisteDto artiste);

    ArtisteDto getArtisteById(String artisteId);

    List<ArtisteDto> getArtistes(int page, int limit);
}
