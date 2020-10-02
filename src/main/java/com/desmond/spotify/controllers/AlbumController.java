package com.desmond.spotify.controllers;

import com.desmond.spotify.dto.AlbumDto;
import com.desmond.spotify.dto.ArtisteDto;
import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.model.UserSummary;
import com.desmond.spotify.request.AlbumRequest;
import com.desmond.spotify.request.ArtisteRequest;
import com.desmond.spotify.response.AlbumResponse;
import com.desmond.spotify.response.ArtisteResponse;
import com.desmond.spotify.services.AlbumService;
import com.desmond.spotify.services.ArtisteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/{artiste_id}/add_album")
    public AlbumResponse addAlbum(@Valid @RequestBody AlbumRequest albumRequest, @PathVariable("artiste_id") String id){

        AlbumDto albumDto = modelMapper.map(albumRequest, AlbumDto.class);

        AlbumDto album = albumService.createAlbum(albumDto, id);

        //return new AlbumResponse(album.getArtisteId(),
                                //album.getAlbumName(),
                                    //album.getDateReleased(),
                                    //album.getProducerName(),
                                    //album.getRecordLabel());
        return null;

    }

    //find all album by artiste name
    @GetMapping("/get_all_artiste_album")
    public List<AlbumResponse> getAllAlbumByArtisteId(@RequestParam("artiste_id") String id){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        List<AlbumResponse> returnValue = new ArrayList<>();

        List<AlbumDto> albums = albumService.getAllAlbumByArtisteId(id);

        Type listType = new TypeToken<List<AlbumResponse>>() {}.getType();

        returnValue = modelMapper.map(albums, listType);

        return returnValue;
    };

}
