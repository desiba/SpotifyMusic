package com.desmond.spotify.serviceImpls;

import com.desmond.spotify.dto.AlbumDto;
import com.desmond.spotify.dto.ArtisteDto;
import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.entities.Album;
import com.desmond.spotify.entities.Artiste;
import com.desmond.spotify.entities.User;
import com.desmond.spotify.exceptions.CustomException;
import com.desmond.spotify.repository.AlbumRepository;
import com.desmond.spotify.repository.ArtisteRepository;
import com.desmond.spotify.services.AlbumService;
import com.desmond.spotify.services.ArtisteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtisteRepository artisteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public AlbumDto createAlbum(AlbumDto albumDto, String artisteId) {

        if (artisteRepository.findByArtisteId(artisteId) == null)
            throw new CustomException(
                400, "invalid artiste id", "can't find artiste associated with the id specified"
            );

        Album album = modelMapper.map(albumDto, Album.class);
        album.setArtisteId(artisteId);

        Album albumResponse = albumRepository.save(album);

        AlbumDto returnValue = modelMapper.map(albumResponse, AlbumDto.class);

        return returnValue;
    }

    @Override
    public List<AlbumDto> getAllAlbumByArtisteId(String artisteId) {
        List<AlbumDto> returnValue = new ArrayList<>();

        Artiste artiste = artisteRepository.findByArtisteId(artisteId);
        if(artiste==null) return returnValue;

        List<Album> albumsList = albumRepository.findAllByArtisteId(artisteId);

        for (Album album : albumsList) {
            AlbumDto albumDto = new AlbumDto();
            modelMapper.map(album, AlbumDto.class);
            returnValue.add(albumDto);
        }

        return returnValue;

    }
}