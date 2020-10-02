package com.desmond.spotify.serviceImpls;

import com.desmond.spotify.dto.ArtisteDto;
import com.desmond.spotify.entities.Album;
import com.desmond.spotify.entities.Artiste;
import com.desmond.spotify.entities.Song;
import com.desmond.spotify.repository.AlbumRepository;
import com.desmond.spotify.repository.ArtisteRepository;
import com.desmond.spotify.repository.SongRepository;
import com.desmond.spotify.request.ArtisteRequest;
import com.desmond.spotify.services.ArtisteService;
import com.desmond.spotify.share.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteServiceImpl implements ArtisteService {

    @Autowired
    ArtisteRepository artisteRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    Utils utils;

    @Override
    public ArtisteDto addArtiste(ArtisteDto artisteRequest) {

        Artiste artiste = modelMapper.map(artisteRequest, Artiste.class);

        artiste.setArtisteId(utils.generateUserId(5));

        Artiste artisteResponse = artisteRepository.save(artiste);

        ArtisteDto returnValue = modelMapper.map(artisteResponse, ArtisteDto.class);

        return returnValue;

    }

    @Override
    public ArtisteDto getArtisteById(String artisteId) {

        Artiste artisteResponse = artisteRepository.findByArtisteId(artisteId);

        ArtisteDto returnValue = modelMapper.map(artisteResponse, ArtisteDto.class);

        return returnValue;


        //Album fromDb = albumRepository.findByArtisteId(artisteId);
        //System.out.println(fromDb.getId());
        //Artiste artiste = new Artiste();
        //artiste.setArtisteId(fromDb.getArtisteId());


    }

    @Override
    public List<ArtisteDto> getArtistes(int page, int limit) {
        return null;
    }
}
